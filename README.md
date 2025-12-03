# Krovat-Tournament.Tournament-System

(BG)
Логическо ядро на турнирна система без графичен интерфейс. Турнирният формат е Double Elimination - поток на победителите и губещите.


1. Описание - Приема списък от произволен брой отбори от конзолата или файл (data.csv). При въвеждане на информация за мачовете симулира придвижването на победителя. В края на турнира извежда победителя и историята на мачовете.


2. Инструкции - Програмата работи през конзолата. Потребителят избира дали да въведе отборите ръчно или да ги зареди от файла. След зареждане на отборите се създава първи рунд в Winners Bracket. Потребителят въвежда победителите във всеки мач, а системата автоматично обновява рундовете и придвижва отборите напред.


3. Алгоритъм - Отборите се разпределят в Winners Bracket и се създава първи рунд. Ако броят е нечетен, последният отбор получава 'bye' и автоматично продължава. След въвеждане на резултатите победителите продължават в следващия рунд на Winners Bracket, а загубилите се прехвърлят в Losers Bracket. Там те се комбинират с победителите от предишния losers рунд за създаване на нови мачове. Процесът се повтаря, докато останат финалисти от победители и загубили.


4. Обяснение на кода - Team, Match, Round и Bracket моделират основните елементи на турнира. Round обработва мачовете и 'bye' случаи. Bracket управлява рундовете за поток на победители или загубили. Tournament координира придвижването на отборите между двата потока и изпълнява логиката на Double Elimination. FileLoader чете и записва отбори, а Main обработва взаимодействието с потребителя.


5. Екип. Разпределение на работата
- Иванета - UML диаграма, полета, конструктори, методи toString(), getters и setters на Team, Match, Round, Bracket и Tournament от Package Tournament, overloaded метод createNextRound в Bracket, Double Elimination логика
- Виктор - UML диаграма, четене от файл и конзолата, Main + Debugging, Double Elimination логика (Support), направи английския вариант на README файла
- Самуил - Отделяне на загубилите и създаване на Losers Bracket в Tournament + README файла
- Игнат - Matches логика + README файла

(EN)
Backend of a tournament system. Uses the Double Elimination format - winners stream and losers stream


1. Description - Uses a list of teams of random size, reads from the console and a file (data.csv). While inserting information about each match, the program simulates how the winner moves in the system. At the end of the tournament returns the winner and the match history.


2. Instructions - The program works through the console. The user chooses whether to insert the teams manually or to load them from the file. After loading the teams the program creates the first round in the Winners Bracket. The user chooses the winner of each match while the system automatically refreshes the rounds and moves the teams forward.


3. Algorithm - The teams are distributed in the Winners Bracket and the first round is created. If the amount of teams is odd, the last team receives a 'bye' and automatically progresses. After the user inserts the results, the winners proceed into the next round of the Winners Bracket, while the losers get sent to the Losers Bracket. There they are mixed with the winners of the previous Losers Bracket round when creating new matches. The process is repeated until there remains only one winner from each bracket.


4. Code Explanation - Team, Match, Round and Bracket form the main elements of the tournament. The Round class handles the matchmaking process and the cases with a 'bye'. The Bracket class manages the rounds for the winners' and losers' respective streams. The Tournament class coordinates and deals with the transfer of the teams between the two streams and follows the Double Elimination logic. The FileLoader class loads and saves teams from and to the system, while Main handles the User Interface.


5. The team and what we worked on
- Ivaneta - UML diagram, fields, constructors, everything connected to the Team, Match, Round, Bracket and Tournament classes, the overloaded method createNextRound (in Bracket), the "heavy lifting" on the Double Elimination logic
- Viktor - UML diagram, reading and writing from and into a file and the console, Main + Debugging, the support on the Double Elimination logic, made the English translation of the README
- Samuil - Separation of the losers from the winners and creating the Losers Bracket in the Tournament Class + worked on the README
- Ignat - The Match logic in Main + worked on the README