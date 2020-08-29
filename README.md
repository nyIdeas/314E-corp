### 314 ECorp WebPage Scan -  Top 10 frequent word and ordered word pairs Assignment

To run the test methods 
-> move to project root folder
-> type "mvn clean"
-> type "mvn install"

To use a new URL to parse change the URL variable in the below Test Class
/314ecorp-webscanner/src/test/java/edu/nyideas/ecorp/webscanner/AppMainTest.java

In the console the unit test results as below appears:-
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running edu.nyideas.ecorp.webscanner.AppMainTest
2020-08-28 04:52:46,041 main ERROR AppenderRef contains an invalid element or attribute "additivity"
Word -> for | Count -> 42
Word -> covid19 | Count -> 43
Word -> healthcare | Count -> 48
Word -> health | Count -> 51
Word -> data | Count -> 46
Word -> to | Count -> 106
Word -> the | Count -> 111
Word -> of | Count -> 55
Word -> a | Count -> 58
Word -> and | Count -> 113
---------------
Word Pair -> during covid19 | Count -> 6
Word Pair -> prepare for | Count -> 7
Word Pair -> the healthcare | Count -> 8
Word Pair -> of the | Count -> 9
Word Pair -> patient safety | Count -> 9
Word Pair -> read more | Count -> 25
Word Pair -> health systems | Count -> 20
Word Pair -> care management | Count -> 10
Word Pair -> news roundup | Count -> 10
Word Pair -> health catalyst | Count -> 17
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.059 sec
```
