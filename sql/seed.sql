USE java_quiz;
INSERT IGNORE INTO topics(topic_name) VALUES ('Java Basics'),('OOP'),('Collections'),('Exceptions & Strings');
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'How many bits does an int occupy in Java?','16','32','64','8',1,'int is always 32-bit in Java.' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which of these is NOT a primitive type?','int','boolean','String','char',2,'String is a reference type.' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Correct signature of the main method?','public static void main(String[] args)','public void main(String[] args)','static int main(String[] args)','public static main(String args)',0,'The JVM looks for public static void main(String[] args). ' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which keyword declares a constant variable?','const','static','final','fixed',2,'final prevents reassignment.' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which loop always runs its body at least once?','for','while','do-while','for-each',2,'do-while checks its condition after the body.' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which keyword creates a new object?','create','malloc','new','alloc',2,'new allocates an object and calls its constructor.' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which operator checks equality of primitives?','=','==','equals','===',1,'== compares primitive values.' FROM topics WHERE topic_name='Java Basics';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which keyword is used to inherit a class?','implements','extends','inherits','super',1,'A subclass uses extends.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Method overloading is an example of:','Compile-time polymorphism','Runtime polymorphism','Encapsulation','Abstraction',0,'Overloading is resolved at compile time.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Can an abstract class be instantiated directly?','Yes','No','Only with new[]','Only inside main',1,'Abstract classes cannot be instantiated directly.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which keyword prevents a method from being overridden?','static','private','final','abstract',2,'A final method cannot be overridden.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'How many interfaces can a class implement?','Only one','Two','Three','Any number',3,'Java permits multiple interfaces.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Hiding fields with private and exposing getters/setters is:','Inheritance','Encapsulation','Polymorphism','Overloading',1,'This is encapsulation.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Method overriding is an example of:','Compile-time polymorphism','Runtime polymorphism','Overloading','Encapsulation',1,'Overridden methods are selected at runtime.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Does Java support multiple inheritance of classes?','Yes','No','Only for abstract classes','Only with final',1,'A class extends only one class; interfaces provide multiple inheritance of type.' FROM topics WHERE topic_name='OOP';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which collection does NOT allow duplicate elements?','List','ArrayList','Set','Vector',2,'A Set holds unique elements.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'How many null keys can a HashMap hold?','None','One','Two','Unlimited',1,'HashMap permits one null key.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Time complexity of ArrayList.get(index)?','O(1)','O(n)','O(log n)','O(n^2)',0,'ArrayList provides constant-time indexed access.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which Map keeps insertion order?','HashMap','TreeMap','Hashtable','LinkedHashMap',3,'LinkedHashMap preserves insertion order.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which structure follows FIFO ordering?','Stack','Queue','TreeSet','HashSet',1,'Queue is First-In-First-Out.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which class implements the Deque interface?','ArrayDeque','TreeSet','HashMap','Vector',0,'ArrayDeque is a resizable double-ended queue.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Correct syntax for a list of Strings?','List<String>','List(String)','List[String]','String<List>',0,'Java generics use angle brackets.' FROM topics WHERE topic_name='Collections';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which of these is a checked exception?','NullPointerException','ArithmeticException','IOException','ArrayIndexOutOfBoundsException',2,'IOException must be caught or declared.' FROM topics WHERE topic_name='Exceptions & Strings';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'When does a finally block NOT run?','After return','After a thrown exception','After a catch block','After System.exit()',3,'System.exit() terminates the JVM.' FROM topics WHERE topic_name='Exceptions & Strings';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which class represents a mutable string?','StringBuilder','String','CharSequence','Character',0,'StringBuilder can be modified in place.' FROM topics WHERE topic_name='Exceptions & Strings';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which keyword manually throws an exception?','throws','throw','raise','catch',1,'throw is used to explicitly throw an exception.' FROM topics WHERE topic_name='Exceptions & Strings';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'Which keyword declares exceptions in a method signature?','throw','throws','try','final',1,'throws declares checked exceptions.' FROM topics WHERE topic_name='Exceptions & Strings';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'What does "Java".length() return?','3','4','5','Error',1,'Java has four characters.' FROM topics WHERE topic_name='Exceptions & Strings';
INSERT INTO questions(topic_id,question_text,option_a,option_b,option_c,option_d,correct_option,explanation)
SELECT topic_id,'What commonly causes StackOverflowError?','Infinite recursion','Null reference','Missing file','Bad cast',0,'Endless recursion exhausts the call stack.' FROM topics WHERE topic_name='Exceptions & Strings';
