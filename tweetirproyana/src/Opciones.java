import twitter4j.PagableResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public final class Opciones {
    
    public static void main(String[] args) 
    {
        if (args.length < 1)
        {
           System.exit(-1);
        }
        try 
        {
            Twitter twitter = new TwitterFactory().getInstance();
            long cursor = -1;
            PagableResponseList<User> users;
            do {
                users = twitter.getFollowersStatuses(args[0], cursor);
                for (User user : users) 
                {
                    if (null != user.getStatus())
                    {
                        System.out.println("@" + user.getScreenName() );
                    } else 
                    {
                         System.out.println("@" + user.getScreenName());
                    }
                }
            } while ((cursor = users.getNextCursor()) != 0);
              System.exit(0);
        } catch (TwitterException te)
        {
            te.printStackTrace();
              System.exit(-1);
        }
    }
}
