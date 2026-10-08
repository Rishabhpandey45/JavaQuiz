let userId=0, questions=[], answers={}, current=0, topicId='', timer=null, remaining=0;
const $=s=>document.querySelector(s);

$('#start').addEventListener('submit', async e=>{
  e.preventDefault();
  try {
    const f=new FormData(e.target);
    const u=await fetch('api/users',{method:'POST',body:f});
    if(!u.ok) throw new Error(await u.text());
    const user=await u.json(); userId=user.userId; topicId=f.get('topicId');
    const endpoint=topicId==='mixed'?'api/questions?mixed=true':'api/questions?topicId='+encodeURIComponent(topicId);
    const qr=await fetch(endpoint);
    if(!qr.ok) throw new Error(await qr.text());
    questions=await qr.json();
    if(!questions.length) throw new Error('No questions found for this topic.');
    current=0; answers={}; $('#start').hidden=true; $('#quiz').hidden=false; startTimer(); render();
  } catch(err) { alert(err.message||'Unable to start quiz.'); }
});

function startTimer(){
  clearInterval(timer); remaining=questions.length*30; updateTimer();
  timer=setInterval(()=>{remaining--; updateTimer(); if(remaining<=0) submitQuiz();},1000);
}
function updateTimer(){const m=Math.floor(remaining/60),s=String(remaining%60).padStart(2,'0'); const t=$('#timer'); if(t)t.textContent=`⏱ ${m}:${s}`;}
function render(){
  const q=questions[current];
  $('#quiz').innerHTML=`<div class="top"><span>Question ${current+1} of ${questions.length}</span><span id="timer"></span></div><div class="bar"><div style="width:${((current+1)/questions.length)*100}%"></div></div><h2>${escapeHtml(q.text)}</h2>${q.options.map((x,i)=>`<div class="option ${answers[q.id]===i?'selected':''}" data-i="${i}">${escapeHtml(x)}</div>`).join('')}<div class="actions"><button id="prev" class="alt" ${current===0?'disabled':''}>Previous</button><button id="next">${current===questions.length-1?'Submit':'Next'}</button></div>`;
  $('#quiz').querySelectorAll('.option').forEach(el=>el.addEventListener('click',()=>{answers[q.id]=Number(el.dataset.i);render();}));
  $('#prev').addEventListener('click',()=>{current--;render();});
  $('#next').addEventListener('click',()=>{if(current<questions.length-1){current++;render();}else submitQuiz();});
  updateTimer();
}
async function submitQuiz(){
  if(!questions.length) return; clearInterval(timer); timer=null;
  const unanswered=questions.filter(q=>answers[q.id]===undefined).length;
  if(unanswered && remaining>0 && !confirm(`${unanswered} question(s) unanswered. Submit anyway?`)){startTimer();render();return;}
  const fd=new URLSearchParams({userId,topicId});
  questions.forEach(q=>{fd.append('questionId',q.id);fd.append('q_'+q.id,answers[q.id]??-1);});
  try{
    const r=await fetch('api/submit',{method:'POST',headers:{'Content-Type':'application/x-www-form-urlencoded'},body:fd});
    if(!r.ok) throw new Error(await r.text());
    const x=await r.json(); $('#quiz').hidden=true; $('#result').hidden=false;
    $('#result').innerHTML=`<h2>Result</h2><div class="stats"><div><b>${x.score}/${x.total}</b><span>Score</span></div><div><b>${x.right}</b><span>Right</span></div><div><b>${x.wrong}</b><span>Wrong</span></div><div><b>${x.skipped}</b><span>Skipped</span></div></div><button onclick="location.reload()">Try Again</button>`;
  }catch(err){alert(err.message||'Unable to submit quiz.');}
}
function escapeHtml(v){return String(v).replace(/[&<>'"]/g,c=>({'&':'&amp;','<':'&lt;','>':'&gt;',"'":'&#39;','"':'&quot;'}[c]));}
