//import twitter4j-core-4.0.4. *;

import java.util.ArrayList;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MyBot {
	
	static ArrayList<Status> tweets = new ArrayList <Status> ();

	public static void main(String[] args) throws TwitterException{
		// TODO Auto-generated method stub
		String latestStatus = "konichiwa";
		Twitter twitter = TwitterFactory.getSingleton();
		//Status status = twitter.updateStatus(latestStatus);
		//Query query = new Query("source: twitter4j yusukey");
		//System.out.println("tweet completed");
		makeSearch("animu"); 
		//makeSearch("")

	}
	
	//(ArrayList <String> a)
	public static void makeSearch(String s) throws TwitterException
	{
		for (int i= 0; i < tweets.size(); i++)
		{
			tweets.remove(i);
		}
		Query query = new Query(s);
		Twitter twitter = TwitterFactory.getSingleton();
		QueryResult result = twitter.search(query);
		//for (int i = 0; i < result, getTweets)
		for (Status t: result. getTweets())
		{
			//tweets.add(t. getText());

			tweets.add(t);
			//System.out.print(t.toString());

			System.out.print(t.getText());
		}
		
		//no arraylist, persay
		//for ()
	}

}
