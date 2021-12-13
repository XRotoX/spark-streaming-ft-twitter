package com.Ingeniance.spark
import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._


 
object PrintTweets {
   def main(args: Array[String]) {  
       // These credentials are revoked please consider using your own
       // Visit https://developer.twitter.com for more
       System.setProperty("twitter4j.oauth.consumerKey", "N5IWiD7jWztbO6sktS0zr6Ct8")
       System.setProperty("twitter4j.oauth.consumerSecret", "3xBUQw9N2dWRrW4XxSyzlmI8MNS3AXG8Nsy3pdMnczUWsrIlwA")
       System.setProperty("twitter4j.oauth.accessToken", "1357063042945712139-2glVWIqkAIBRuUP0S7DnVvUsphxSPe")
       System.setProperty("twitter4j.oauth.accessTokenSecret", "70Wrhz5T7uSoatFPCkzQaBU3NQmwWwL28Vw1wqqh3hfsq")          
        
       val ssc = new StreamingContext("local[*]", "PrintTweets", Duration(1000))
       val filters = Array("covid19")
       val tweets = TwitterUtils.createStream(ssc, None, filters)
       val statuses = tweets.map(status => status.getText())
       statuses.print()

       val englishTweets = tweets.filter(_.getLang() == "en")
       englishTweets.saveAsTextFiles("tweets", "json")

       ssc.start()
       ssc.awaitTermination()

   }
}
