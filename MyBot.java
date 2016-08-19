//import twitter4j-core-4.0.4. *;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MyBot {
	
	//one ArrayList will store the tweet objects we want to find
	
	static ArrayList<Status> tweets = new ArrayList <Status> ();
	
	//one Arraylist will store the search -terms- tweets we want to use
	static List<String> searches = new ArrayList<String>();
	
	//one Arraylist will sotre the reply tweets as strings
	static List <String> replies = new ArrayList<String>();

	public static void main(String[] args) throws TwitterException, InterruptedException{
		// TODO Auto-generated method stub
		String latestStatus = "konichiwa";
		Twitter twitter = TwitterFactory.getSingleton();
		//Status status = twitter.updateStatus(latestStatus);
		//Query query = new Query("source: twitter4j yusukey");
		//System.out.println("tweet completed");
		//makeSearch("ice cream"); 
		//makeSearch("")
		
//		searches.add("#flooding");
		searches.add("#prayforlouisiana");
		searches.add("#flooding");
		searches.add("Louisiana Flood");
		searches.add("Louisiana flooding");
		
		replies.add(" In addition to sending condolences, please also consider making a donation to the cause at https://www.redcross.org/donate/donation?campname=genericflood&campmedium=aspot_mo2");
		
		//"to- "
		replies.add(" Please help victims of the Louisiana #flooding by donating at https://www.redcross.org/donate/donation?campname=genericflood&campmedium=aspot_mo2. all help is greatly appreciated and honored");
		
		//keep tweeting forever
		while(true)
		{
			//create new querey
			for(int i = 0; i <= searches.size(); i++)
			{
				//Query query = new Query(searches.get(index)); i is acting as index- 0, 1, ...
				//cant we just do for draw? mi: it's not processing. 
				Query query = new Query(searches.get(i));
				QueryResult result = twitter.search(query);
				
				//retrieve the tweet from these search results:
				Status tweetResult = result.getTweets().get(0);
				
				//reply to that tweet with one of our replies:
				if(i == 0)
				{
					StatusUpdate statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() + replies.get(i));
					statusUpdate.inReplyToStatusId(tweetResult.getId());
					Status satus = twitter.updateStatus(statusUpdate);
				} else 
				{
					//there's only 2 reply, starts at 0, micha's = 0-..
					StatusUpdate statusUpdate = new StatusUpdate(".@" + tweetResult.getUser().getScreenName() + replies.get(1));
					statusUpdate.inReplyToStatusId(tweetResult.getId());
					Status satus = twitter.updateStatus(statusUpdate);
				}				
				
			}
			
			//querys for each one of our search terms
			//sleep for one hour- wild loop run for 1 hr -each-
			System.out.println("sleeping");			
			Thread.sleep(60*60*1000);
				
		}

	}
	
	//(ArrayList <String> a)
	public static void makeSearch(String s) throws TwitterException
	{
		//for (int i= 0; i <= tweets.size(); i++)
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
