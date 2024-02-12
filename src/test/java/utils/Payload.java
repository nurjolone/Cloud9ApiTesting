package utils;

public class Payload {
public static String createPerson(String givenName,
                                  String familyName,
                                  String gender,
                                  String birthdate,
                                  String cityVillage){
    return "{\n" +
            "    \"names\": [\n" +
            "        {\n" +
            "        \"givenName\": \" "+givenName+"\",\n" +
            "        \"familyName\": \" "+familyName+"\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"gender\": \""+gender+"\",\n" +
            "    \"birthdate\": \""+birthdate+"\",\n" +
            "    \"addresses\": [\n" +
            "        {\n" +
            "        \"address1\": \"501 Spring\",\n" +
            "        \"cityVillage\": \""+cityVillage+"\",\n" +
            "        \"country\": \"Mars\",\n" +
            "        \"postalCode\": \"89003\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
    }

    public static String createPatient(String identifier,String personID){
    return "{\n" +
            "   \"identifiers\": [\n" +
            "       {\n" +
            "         \"identifier\":\""+identifier+"\",\n" +
            "         \"identifierType\":\"05a29f94-c0ed-11e2-94be-8c13b969e334\",\n" +
            "         \"location\":\"7f65d926-57d6-4402-ae10-a5b3bcbf7986\",\n" +
            "         \"preferred\":true\n" +
            "       } ],\n" +
            "   \"person\":\""+personID+"\"\n" +
            "}";

    }


}
