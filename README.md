# Titanic Data Visualization

##### Project created for assessment of subject "JAVA and UML Programming"

## Author:
```
PATIL Kunal
MSc, Artificial Intelligence
EPITA
```

## Resources used:
```
IDE: IntelliJ IDEA 2020.1.2
Framework: Spark 3.0.0
Plugin: Scala 2.12
Programming Language: JAVA 11   
```

## Arborescence
```
Titanic_data-
    |- src
        |- dataset
            |- TitanicInfo.csv
        |- main
            |- java
                |- app.java
        |- test
    |- target
    |- pom.xml
```

## Sample Output
```
Total Survival Rate
+--------+-----+
|Survived|Count|
+--------+-----+
|       1|  342|
|       0|  545|
+--------+-----+

Total Survival Percentage
+--------+----------+
|Survived|Percentage|
+--------+----------+
|       1|     38.56|
|       0|     61.44|
+--------+----------+

Number of people on ship based on Gender
+------+-----+
|   Sex|Count|
+------+-----+
|female|  314|
|  male|  573|
+------+-----+

Percentage of people on ship based on Gender
+------+----------+
|   Sex|Percentage|
+------+----------+
|female|      35.4|
|  male|      64.6|
+------+----------+

Survival Rate by Gender
+--------+------+-----+
|Survived|   Sex|Count|
+--------+------+-----+
|       1|female|  233|
|       0|female|   81|
|       1|  male|  109|
|       0|  male|  464|
+--------+------+-----+

Survival Percentage by Gender
+--------+------+----------+
|Survived|   Sex|Percentage|
+--------+------+----------+
|       1|female|     26.27|
|       0|female|      9.13|
|       1|  male|     12.29|
|       0|  male|     52.31|
+--------+------+----------+

Number of people on ship based on Passenger Class
+------+--------+
|Pclass|count(1)|
+------+--------+
|     1|     216|
|     3|     487|
|     2|     184|
+------+--------+

Percentage of people on ship based on Passenger Class
+------+----------+
|Pclass|Percentage|
+------+----------+
|     1|     24.35|
|     3|      54.9|
|     2|     20.74|
+------+----------+

Survival Rate by Passenger Class
+--------+------+-----+
|Survived|Pclass|Count|
+--------+------+-----+
|       0|     1|   80|
|       1|     1|  136|
|       0|     2|   97|
|       1|     2|   87|
|       1|     3|  119|
|       0|     3|  368|
+--------+------+-----+

Survival Percentage by Passenger Class
+--------+------+----------+
|Survived|Pclass|Percentage|
+--------+------+----------+
|       0|     1|      9.02|
|       1|     1|     15.33|
|       0|     2|     10.94|
|       1|     2|      9.81|
|       1|     3|     13.42|
|       0|     3|     41.49|
+--------+------+----------+

Survival Rate for Passenger Class by Gender
+--------+------+------+-----+
|Survived|Pclass|   Sex|Count|
+--------+------+------+-----+
|       1|     1|female|   91|
|       0|     1|  male|   77|
|       0|     1|female|    3|
|       1|     1|  male|   45|
|       0|     2|female|    6|
|       1|     2|  male|   17|
|       0|     2|  male|   91|
|       1|     2|female|   70|
|       1|     3|female|   72|
|       1|     3|  male|   47|
|       0|     3|female|   72|
|       0|     3|  male|  296|
+--------+------+------+-----+

Survival Percentage for Passenger Class by Gender
+--------+------+------+----------+
|Survived|Pclass|   Sex|Percentage|
+--------+------+------+----------+
|       1|     1|female|     10.26|
|       0|     1|  male|      8.68|
|       0|     1|female|      0.34|
|       1|     1|  male|      5.07|
|       0|     2|female|      0.68|
|       1|     2|  male|      1.92|
|       0|     2|  male|     10.26|
|       1|     2|female|      7.89|
|       1|     3|female|      8.12|
|       1|     3|  male|       5.3|
|       0|     3|female|      8.12|
|       0|     3|  male|     33.37|
+--------+------+------+----------+

Number of people on ship based on Age Group
+--------+-----+
|AgeGroup|Count|
+--------+-----+
|   Adult|  721|
|   Child|  166|
+--------+-----+

Percentage of people on ship based on Age Group
+--------+----------+
|AgeGroup|Percentage|
+--------+----------+
|   Adult|     81.29|
|   Child|     18.71|
+--------+----------+

Survival Rate by Age group
+--------+--------+-----+
|Survived|AgeGroup|Count|
+--------+--------+-----+
|       0|   Adult|  457|
|       1|   Child|   78|
|       1|   Adult|  264|
|       0|   Child|   88|
+--------+--------+-----+

Survival Percentage by Age group
+--------+--------+----------+
|Survived|AgeGroup|Percentage|
+--------+--------+----------+
|       0|   Adult|     51.52|
|       1|   Child|      8.79|
|       1|   Adult|     29.76|
|       0|   Child|      9.92|
+--------+--------+----------+

Survival Rate for each Gender by Age Group
+--------+------+--------+-----+
|Survived|   Sex|AgeGroup|Count|
+--------+------+--------+-----+
|       0|female|   Child|   29|
|       1|  male|   Adult|   82|
|       0|  male|   Adult|  405|
|       0|female|   Adult|   52|
|       1|female|   Adult|  182|
|       1|female|   Child|   51|
|       1|  male|   Child|   27|
|       0|  male|   Child|   59|
+--------+------+--------+-----+

Survival Percentage for each Gender by Age Group
+--------+------+--------+----------+
|Survived|   Sex|AgeGroup|Percentage|
+--------+------+--------+----------+
|       0|female|   Child|      3.27|
|       1|  male|   Adult|      9.24|
|       0|  male|   Adult|     45.66|
|       0|female|   Adult|      5.86|
|       1|female|   Adult|     20.52|
|       1|female|   Child|      5.75|
|       1|  male|   Child|      3.04|
|       0|  male|   Child|      6.65|
+--------+------+--------+----------+

Survival Rate by Passenger Class and Age Group
+--------+------+--------+-----+
|Survived|PClass|AgeGroup|Count|
+--------+------+--------+-----+
|       0|     3|   Adult|  288|
|       1|     1|   Child|   14|
|       0|     1|   Adult|   78|
|       1|     3|   Child|   41|
|       1|     3|   Adult|   78|
|       0|     2|   Child|    6|
|       0|     1|   Child|    2|
|       1|     1|   Adult|  122|
|       1|     2|   Adult|   64|
|       0|     2|   Adult|   91|
|       1|     2|   Child|   23|
|       0|     3|   Child|   80|
+--------+------+--------+-----+

Survival Percentage by Passenger Class and Age Group
+--------+------+--------+----------+
|Survived|PClass|AgeGroup|Percentage|
+--------+------+--------+----------+
|       0|     3|   Adult|     32.47|
|       1|     1|   Child|      1.58|
|       0|     1|   Adult|      8.79|
|       1|     3|   Child|      4.62|
|       1|     3|   Adult|      8.79|
|       0|     2|   Child|      0.68|
|       0|     1|   Child|      0.23|
|       1|     1|   Adult|     13.75|
|       1|     2|   Adult|      7.22|
|       0|     2|   Adult|     10.26|
|       1|     2|   Child|      2.59|
|       0|     3|   Child|      9.02|
+--------+------+--------+----------+

Number of people on ship of different Titles
+--------+-----+
|   Title|Count|
+--------+-----+
|     Don|    1|
|    Miss|  182|
|     Col|    2|
|     Rev|    6|
|    Lady|    1|
|  Master|   40|
|     Mme|    1|
|    Capt|    1|
|      Mr|  513|
|      Dr|    7|
|      th|    1|
|     Mrs|  125|
|     Sir|    1|
|Jonkheer|    1|
|    Mlle|    2|
|   Major|    2|
|      Ms|    1|
+--------+-----+

Percentage of people on ship of different Titles
+--------+----------+
|   Title|Percentage|
+--------+----------+
|     Don|      0.11|
|    Miss|     20.52|
|     Col|      0.23|
|     Rev|      0.68|
|    Lady|      0.11|
|  Master|      4.51|
|     Mme|      0.11|
|    Capt|      0.11|
|      Mr|     57.84|
|      Dr|      0.79|
|      th|      0.11|
|     Mrs|     14.09|
|     Sir|      0.11|
|Jonkheer|      0.11|
|    Mlle|      0.23|
|   Major|      0.23|
|      Ms|      0.11|
+--------+----------+

Amount of Fare based on Survival Rate
+--------+---------+
|Survived|   Amount|
+--------+---------+
|       0|12103.678|
|       1|16551.229|
+--------+---------+

Amount of Fare based on Gender
+------+---------+
|   Sex|   Amount|
+------+---------+
|female|13966.663|
|  male|14688.245|
+------+---------+

Amount of Fare based on Passenger Class
+------+---------+
|PClass|   Amount|
+------+---------+
|     1|18177.412|
|     2| 3801.842|
|     3| 6675.654|
+------+---------+

+--------+----------+
|Survived|prediction|
+--------+----------+
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       1.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
|       0|       0.0|
+--------+----------+
only showing top 20 rows

accuracy : 0.8491620111731844

Confusion Matrix:
95.0  10.0  
17.0  57.0  

Feature calculation for each columns:
Passenger Class: 0.1935417036561642
Age: 0.09942478970050685
FamilySize: 0.09733191173998515
Fare: 0.009857557150909526
indexSex: 0.5998440377524343

```


## Github:    
https://github.com/kunalpatz/Titanic_data

