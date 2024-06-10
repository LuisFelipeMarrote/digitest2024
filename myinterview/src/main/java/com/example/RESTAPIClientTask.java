package com.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.io.IOException;
import java.util.Scanner;
import Records;
/**
 * This task expects you to create an implementation of a Rest API client.
 * Your code should call the API endpoint related below.
 * After receiving the JSON Response, print out how many records exists for each gender
 * API endpoint => https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * 
 * >>> Bonus <<<
 * Generate a CSV file containing many records exists for each gender and save this file to AWS S3 Bucket
 * The filename need to contains your entire name, separated by uderscore. Example: john_lennon.csv
 * AWS S3 bucket name => interview-digiage
 * The credentials you can find in Coodesh platform or ask via e-mail for recrutamento@digiage.com.br
 */  
// API endpoint => https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
//{"emp_no": 10001, "first_name": "Georgie", "last_name": "Facello", "gender": "M"} FORMATO DO JSON.
public class RESTAPIClientTask {
    public static void main(String[] args) throws IOException{
        // METODO GET 
        var recordsM = 0;
        var recordsF = 0;
        var endpoint = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";
        URL urlObjetivo = new URL(endpoint);
        HttpsURLConnection connection = (HttpsURLConnection) urlObjetivo.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if(responseCode == HttpsURLConnection.HTTP_OK){
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNext()){
                sb.append(scanner.nextLine());
            }
            ObjectMapper objectMapper = new ObjectMapper();
            Records[] records = objectMapper.readValue(String.valueOf(sb), new TypeReference <Records[]>() {});
        }

        for (Records elemt : records){
            if (elemt.getGender = "M"){
                recordsM += 1; 
            }
            else 
                recordsF += 1;
        }

        System.out.println("Número de discos de autores: " + recordsM);
        System.out.println("Número de discos de autoras: " + recordsF);

    }
  
}