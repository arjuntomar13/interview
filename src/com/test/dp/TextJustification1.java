package com.test.dp;

public class TextJustification1 {

    public String justify(String words[], int width) {
        
        int cost[][] = new int[words.length][words.length];
        
        //next 2 for loop is used to calculate cost of putting words from
        //i to j in one line. If words don't fit in one line then we put
        //Integer.MAX_VALUE there.
        for(int i=0 ; i < words.length; i++){
            cost[i][i] = width - words[i].length();
            for(int j=i+1; j < words.length; j++){
                cost[i][j] = cost[i][j-1] - words[j].length() - 1; 
            }
        }
        
        for(int i=0; i < words.length; i++){
            for(int j=i; j < words.length; j++){
                if(cost[i][j] < 0){
                    cost[i][j] = Integer.MAX_VALUE;
                }else{
                    cost[i][j] = (int)Math.pow(cost[i][j], 2);
                }
            }
        }
        
        //minCost from i to len is found by trying
        //j between i to len and checking which
        //one has min value
        int minCost[] = new int[words.length];
        int result[] = new int[words.length];
        for(int i = words.length-1; i >= 0 ; i--){
            minCost[i] = cost[i][words.length-1];
            result[i] = words.length;
            for(int j=words.length-1; j > i; j--){
                if(cost[i][j-1] == Integer.MAX_VALUE){
                    continue;
                }
                if(minCost[i] > minCost[j] + cost[i][j-1]){
                    minCost[i] = minCost[j] + cost[i][j-1];
                    result[i] = j;
                }
            }
        }
        int i = 0;
        int j;
        
        System.out.println("Minimum cost is " + minCost[0]);
        System.out.println("\n");
        
        //finally put all words with new line added in 
        //string buffer and print it.
        StringBuilder builder = new StringBuilder();
        do{
            j = result[i];
            for(int k=i; k < j; k++){
                builder.append(words[k] + " ");
            }
            builder.append("\n");
            i = j;
        }while(j < words.length);
        
        return builder.toString();
    }
    
    public static void main(String args[]){
//    	String test = "A blog a truncation of the expression weblog is a discussion or informational site published on the World Wide Web consisting of discrete entries posts typically displayed in reverse chronological order the most recent post appears first Until 2009 blogs were usually the work of a single individualcitation needed occasionally of a small group and often covered a single subject More recently multi-author blogs MABs have developed with posts written by large numbers of authors and professionally edited MABs from newspapers other media outlets universities think tanks advocacy groups and similar institutions account for an increasing quantity of blog traffic The rise of Twitter and other microblogging systems helps integrate MABs and single-author blogs into societal newstreams Blog can also be used as a verb meaning to maintain or add content to a blog The emergence and growth of blogs in the late 1990s coincided with the advent of web publishing tools that facilitated the posting of content by non-technical users Previously a knowledge of such technologies as HTML and FTP had been required to publish content on the Web A majority are interactive allowing visitors to leave comments and even message each other via GUI widgets on the blogs and it is this interactivity that distinguishes them from other static websites2 In that sense blogging can be seen as a form of social networking service Indeed bloggers do not only produce content to post on their blogs but also build social relations with their readers and other bloggers3 However there are high-readership blogs which do not allow comments Many blogs provide commentary on a particular subject others function as more personal online diaries others function more as online brand advertising of a particular individual or company A typical blog combines text images and links to other blogs web pages and other media related to its topic The ability of readers to leave comments in an interactive format is an important contribution to the popularity of many blogs Most blogs are primarily textual although some focus on art art blogs photographs photoblogs videos video blogs or vlogs music MP3 blogs and audio podcasts Microblogging is another type of blogging featuring very short posts In education blogs can be used as instructional resources These blogs are referred to as edublogs On 16 February 2011 there were over 156 million public blogs in existence On 20 February 2014 there were around 172 million Tumblr4 and 758 million WordPress5 blogs in existence worldwide According to critics and other bloggers Blogger is the most popular blogging service used today However Blogger does not offer public statistics Technorati has 13 million blogs as of February 22 2014";
        String words1[] = {"Jack","likes","to","write","code","at", "free", "time"};
//        String[] words1 = test.split(" ");
        TextJustification1 awl = new TextJustification1();
        System.out.println(awl.justify(words1, 12));
    }
}