import org.apache.spark.ml.classification.DecisionTreeClassificationModel;
import org.apache.spark.ml.classification.DecisionTreeClassifier;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.mllib.evaluation.MulticlassMetrics;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;


public class app {
    public static void main(String[] args) {
        SparkSession app = SparkSession.builder()
                .config("spark.master", "local")
                .config("spark.ui.enabled", false)
                .appName("titanic").getOrCreate();

        Dataset<Row> df = app.read().format("csv").option("header", "true").option("inferSchema", "true")
                .csv("src/dataset/TitanicInfo.csv").na().drop();

        app.sparkContext().setLogLevel("ERROR");

        df = df.withColumn("AgeGroup",
                functions.when(functions.col("Age")
                        .between(0, 18), functions.lit("Child")).otherwise("Adult"));

        df = df.withColumn("FamilySize", df.col("Siblings/Spouses Aboard")
                .plus(df.col("Parents/Children Aboard")));

        df = df.withColumn("Title", functions.split(functions.col("Name"), ". ").getItem(0));

        df = df.drop("Parents/Children Aboard").drop("Siblings/Spouses Aboard").drop("Name");



        Dataset<Row> survivalRate = df.sort(functions.asc("Survived"))
                .groupBy("Survived").agg(functions.count("*").alias("Count"));
        System.out.println("Total Survival Rate");
        survivalRate.show();


        Dataset<Row> survivalPercentage = df.groupBy("Survived")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("Survived")
                        .count()).multiply(100), 2).alias("Percentage"));
        System.out.println("Total Survival Percentage");
        survivalPercentage.show();


        Dataset<Row> survivalRateByGender = df.sort(functions.asc("Survived"))
                .groupBy("Sex").agg(functions.count("*").alias("Count"));
        System.out.println("Number of people on ship based on Gender");
        survivalRateByGender.show();


        Dataset<Row> survivalByGenderPercentage = df.sort(functions.asc("Survived"))
                .groupBy("Sex")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("Sex")
                        .count()).multiply(100), 2).alias("Percentage"));
        System.out.println("Percentage of people on ship based on Gender");
        survivalByGenderPercentage.show();


        Dataset<Row> survivalRateByEachGender = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Sex")
                .agg(functions.count("*").alias("Count")).orderBy("Sex");
        System.out.println("Survival Rate by Gender");
        survivalRateByEachGender.show();

        Dataset<Row> survivalByEachGenderPercentage = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Sex")
                .agg(functions.round(functions.count("*").divide(df.select("Sex")
                        .count()).multiply(100), 2).alias("Percentage")).orderBy("Sex");
        System.out.println("Survival Percentage by Gender");
        survivalByEachGenderPercentage.show();


        Dataset<Row> survivalRateByPClass = df.sort(functions.asc("Survived"))
                .groupBy("Pclass").agg(functions.count("*"));
        System.out.println("Number of people on ship based on Passenger Class");
        survivalRateByPClass.show();


        Dataset<Row> survivalByPClassPercentage = df.groupBy("Pclass")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("Pclass").count()).multiply(100), 2).alias("Percentage"));
        System.out.println("Percentage of people on ship based on Passenger Class");
        survivalByPClassPercentage.show();


        Dataset<Row> survivalRateByEachPClass = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Pclass").agg(functions.count("*").alias("Count"))
                .orderBy("Pclass");
        System.out.println("Survival Rate by Passenger Class");
        survivalRateByEachPClass.show();


        Dataset<Row> survivalByEachPClassPercentage = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Pclass")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("Pclass").count()).multiply(100), 2)
                        .alias("Percentage")).orderBy("Pclass");
        System.out.println("Survival Percentage by Passenger Class");
        survivalByEachPClassPercentage.show();


        Dataset<Row> survivalRateByPClassByGender = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Pclass", "Sex")
                .agg(functions.count("*").alias("Count")).orderBy("Pclass");
        System.out.println("Survival Rate for Passenger Class by Gender");
        survivalRateByPClassByGender.show();


        Dataset<Row> survivalByPClassByGenderPercentage = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Pclass", "Sex")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("Pclass").count()).multiply(100), 2)
                        .alias("Percentage")).orderBy("Pclass");
        System.out.println("Survival Percentage for Passenger Class by Gender");
        survivalByPClassByGenderPercentage.show();


        Dataset<Row> survivalRateByAgeGroup = df.sort(functions.asc("Survived"))
                .groupBy("AgeGroup").agg(functions.count("*").alias("Count"));
        System.out.println("Number of people on ship based on Age Group");
        survivalRateByAgeGroup.show();


        Dataset<Row> survivalByAgeGroupPercentage = df.groupBy("AgeGroup")
                .agg(functions.round(functions.count("*").divide(df.select("AgeGroup").count())
                        .multiply(100), 2).alias("Percentage"));
        System.out.println("Percentage of people on ship based on Age Group");
        survivalByAgeGroupPercentage.show();


        Dataset<Row> survivalRateByEachAgeGroup = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "AgeGroup").agg(functions.count("*").alias("Count"));
        System.out.println("Survival Rate by Age group");
        survivalRateByEachAgeGroup.show();


        Dataset<Row> survivalByEachAgeGroupPercentage = df.groupBy("Survived", "AgeGroup")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("AgeGroup").count())
                        .multiply(100), 2).alias("Percentage"));
        System.out.println("Survival Percentage by Age group");
        survivalByEachAgeGroupPercentage.show();


        Dataset<Row> survivalRateByGenderAgeGroup = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Sex", "AgeGroup")
                .agg(functions.count("*").alias("Count"));
        System.out.println("Survival Rate for each Gender by Age Group");
        survivalRateByGenderAgeGroup.show();


        Dataset<Row> survivalByGenderAgeGroupPercentage = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "Sex", "AgeGroup")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("AgeGroup")
                        .count()).multiply(100), 2).alias("Percentage"));
        System.out.println("Survival Percentage for each Gender by Age Group");
        survivalByGenderAgeGroupPercentage.show();


        Dataset<Row> survivalRateByPClassAgeGroup = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "PClass", "AgeGroup")
                .agg(functions.count("*").alias("Count"));
        System.out.println("Survival Rate by Passenger Class and Age Group");
        survivalRateByPClassAgeGroup.show();


        Dataset<Row> survivalByPClassAgeGroupPercentage = df.sort(functions.asc("Survived"))
                .groupBy("Survived", "PClass", "AgeGroup")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("AgeGroup")
                        .count()).multiply(100), 2).alias("Percentage"));
        System.out.println("Survival Percentage by Passenger Class and Age Group");
        survivalByPClassAgeGroupPercentage.show();


        Dataset<Row> survivalRateByTitle = df.sort(functions.asc("Survived"))
                .groupBy("Title").agg(functions.count("*").alias("Count"));
        System.out.println("Number of people on ship of different Titles");
        survivalRateByTitle.show();


        Dataset<Row> survivalByTitlePercentage = df.groupBy("Title")
                .agg(functions.round(functions.count("*")
                        .divide(df.select("Title").count())
                        .multiply(100), 2).alias("Percentage"));
        System.out.println("Percentage of people on ship of different Titles");
        survivalByTitlePercentage.show();


        Dataset<Row> survivalRateByFare = df.sort(functions.asc("Survived"))
                .groupBy("Survived")
                .agg(functions.round(functions.sum(functions.col("Fare")), 3)
                        .alias("Amount"));
        System.out.println("Amount of Fare based on Survival Rate");
        survivalRateByFare.show();


        Dataset<Row> FarePerGender = df.sort(functions.asc("Sex"))
                .groupBy("Sex")
                .agg(functions.round(functions.sum(functions.col("Fare")), 3)
                        .alias("Amount"));
        System.out.println("Amount of Fare based on Gender");
        FarePerGender.show();


        Dataset<Row> FarePerClass = df.sort(functions.asc("PClass"))
                .groupBy("PClass")
                .agg(functions.round(functions.sum(functions.col("Fare")), 3).alias("Amount"));
        System.out.println("Amount of Fare based on Passenger Class");
        FarePerClass.show();


        StringIndexer sexIndexer = new StringIndexer();
        df = sexIndexer.setInputCol("Sex").setOutputCol("indexedSex").fit(df).transform(df);

        // Splitting DataSet into train and test models

        Dataset<Row>[] trainTestSplit = df.randomSplit(new double[]{0.8, 0.2});

        Dataset<Row> trainDf = trainTestSplit[0];
        Dataset<Row> testDf = trainTestSplit[1];

        // Extraction of Features

        String featuresColumn = "features";

        VectorAssembler vectorAssembler = new VectorAssembler().setInputCols(new String[]{"Pclass", "Age",
                "FamilySize", "Fare", "indexedSex"})
                .setOutputCol(featuresColumn);
        trainDf = vectorAssembler.transform(trainDf);
        testDf = vectorAssembler.transform(testDf);


        // Set the prediction
        DecisionTreeClassifier decisionTree = new DecisionTreeClassifier().setLabelCol("Survived")
                .setPredictionCol("prediction").setFeaturesCol(featuresColumn);

        DecisionTreeClassificationModel model = decisionTree.fit(trainDf);
        Dataset<Row> predicted = model.transform(testDf);

        Dataset<Row> truthVsPrediction = predicted.select("Survived", "prediction");

        truthVsPrediction.show();

        // Renaming Survived column
        truthVsPrediction = truthVsPrediction
                .withColumn("Survived_temp", truthVsPrediction.col("Survived").cast(DataTypes.DoubleType)).drop("Survived")
                .withColumnRenamed("Survived_temp", "Survived");

        MulticlassMetrics metrics = new MulticlassMetrics(truthVsPrediction);

        System.out.println("accuracy : " + metrics.accuracy());
        System.out.println(metrics.confusionMatrix().toString());

        double[] doubleArray = model.featureImportances().toArray();
        for (double d : doubleArray) {
            System.out.println(d);
        }


    }

}
