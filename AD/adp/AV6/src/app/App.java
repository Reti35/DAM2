package app;

public class App {

	public static void main(String[] args) {
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("canciones");
		
	}

}
