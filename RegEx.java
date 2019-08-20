1.	Simple RegEx:

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.*;

public void SimpleRegEx()
    {   
        String fullstring = "is is is is is";
        String substr = "is";
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        int count = 0;
    
        //lookingAt() method only matches the regular expression against the beginning of the text,
        System.out.println("Matches lookign at " + mat.lookingAt()); //true

        //reset - matching will start from the beginning of the text again.
        mat.reset(); 
        
        //matches() matches the regular expression against the whole text.
        System.out.println("Matcher matches " + mat.matches()); //false
       
        while (mat.find())
        {
        	count++;
        	System.out.println("Matcher " + count + "= " + mat.start()+ "-" +mat.end());
        	/* output:
        	    Matcher 1= 0-2
	 			Matcher 2= 3-5
				Matcher 3= 6-8
				Matcher 4= 9-11
				Matcher 5= 12-14 
        	 */
        }
        System.out.println("Matches found " + count); //5    
 
    }
2.	RegEx with Groups: “(is)”

public void RegExGroup()
    {   
        String fullstring = "isha";
//group using ()
        String substr = "(is)"; 
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        int count = 0;   
                    
        while (mat.find())
        {
        	count++;
        	//The group with number 0 is always the whole regular expression
        	System.out.println("Matcher group 0 " + count + "= " + mat.group(0));
        	System.out.println("Matcher group 1 " + count + "= " + mat.group(1));
        	/* o/p: Matcher group 0 1= is
				Matcher group 1 1= is        	 */
        }
        System.out.println("Matches found " + count); //1
    }
3.	Reg Ex with multiple groups: “(is) (.+?) “

Space -> space between words and after words
. -> any character
+ -> one or more times
? -> match as small as a no of chars as possible


public void RegExWithMultiGrps()
    {   
        String fullstring = "is ha is hitha is hika is huuu";
        //groups can be defined with different ()
        String substr = "(is) (.+?) ";
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        int count = 0;   
                    
        while (mat.find())
        {
        	count++;
        	//The group with number 0 is always the whole regular expression
        	System.out.println("Matcher group 0 " + count + "= " + mat.group(0));
        	System.out.println("Matcher group 1 " + count + "= " + mat.group(1));
        	System.out.println("Matcher group 2 " + count + "= " + mat.group(2));
        }
        System.out.println("Matches found " + count); //1
    }
//Please note the regex matched only 3 becz the last string does not has space

Output:
Matcher group 0 1= is ha 
Matcher group 1 1= is
Matcher group 2 1= ha
Matcher group 0 2= is hitha 
Matcher group 1 2= is
Matcher group 2 2= hitha
Matcher group 0 3= is hika 
Matcher group 1 3= is
Matcher group 2 3= hika
Matches found 3
4.	Reg Ex with nested Groups: “((is) (.+?) )“
Group 1 - outer parenthesis big group ()
Group 2 - first expresstion (is)
Group 3 - 2nd expression (.+?)

public void RegExWithMultiGrps()
    {   
        String fullstring = "is ha is hitha ";
        //groups can be defined with different ()
        String substr = "((is) (.+?) )";
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        int count = 0;   
                    
        while (mat.find())
        {
        	count++;
        	//The group with number 0 is always the whole regular expression
        	System.out.println("Matcher group 0 " + count + "= " + mat.group(0));
        	System.out.println("Matcher group 1 " + count + "= " + mat.group(1));
        	System.out.println("Matcher group 2 " + count + "= " + mat.group(2));
        	System.out.println("Matcher group 3 " + count + "= " + mat.group(3));        	
        }
        System.out.println("Matches found " + count);
    }
Output:
Matcher group 0 1= is ha 
Matcher group 1 1= is ha 
Matcher group 2 1= is
Matcher group 3 1= ha
Matcher group 0 2= is hitha 
Matcher group 1 2= is hitha 
Matcher group 2 2= is
Matcher group 3 2= hitha
Matches found 2
5.	Replace ALL and Replace First

public void RegExWithReplace()
    {   
        String fullstring = "is ha happy is hitha birthday is hello chitra";
        //groups can be defined with different ()
        String substr = "((is) (.+?) )";
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        
        String  output = mat.replaceAll("was ");
        System.out.println("Replaceall :" + output);                    
        
        String  output1 = mat.replaceFirst("was ");
        System.out.println("Replace First :" + output1);
    }
Output:
Replaceall :was happy was birthday was chitra
Replace First :was happy is hitha birthday is hello Chitra
6.	Append Replacement:

public void RegExWithReplace()
    {   
        String fullstring = "is ha happy is hitha birthday is hello chitra";
        //groups can be defined with different ()
        String substr = "((is) (.+?) )";
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        StringBuffer sb = new StringBuffer();
      while(mat.find())
      {
    	  mat.appendReplacement(sb,"was ");
    	  System.out.println("AppendReplacement : " +sb);
      }
      System.out.println("Final AppendReplacement : " +sb);
    }
Output:
AppendReplacement : was 
AppendReplacement : was happy was 
AppendReplacement : was happy was birthday was 
Final AppendReplacement : was happy was birthday was
7.	AppendTail:

    public void RegExWithReplace()
    {   
        String fullstring = "is ha happy is hitha birthday is hello chitra";
        //groups can be defined with different ()
        String substr = "((is) (.+?) )";
        Pattern pat = Pattern.compile(substr);
        Matcher mat = pat.matcher(fullstring);
        StringBuffer sb = new StringBuffer();
      while(mat.find())
      {
    	  mat.appendReplacement(sb,"was ");
    	  System.out.println("AppendReplacement : " +sb);
      }
      mat.appendTail(sb);
      System.out.println("Final AppendReplacement : " +sb);
    }
Output:
AppendReplacement : was 
AppendReplacement : was happy was 
AppendReplacement : was happy was birthday was 
Final AppendReplacement : was happy was birthday was Chitra




