package apple;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class stringProblemTest {
	@DataProvider(name= "inputPositiveTesting")
	public Object[][] generateDataSetPositive() {
		return new Object [][]{
		    new Object[] {"cantalope",'a',"cntlope","iterate"},
	    	new Object[] {"cantalope",'a',"cntlope","oneLine"}		    	 
		};
	}
	@DataProvider(name= "inputNegativeTesting")
	public Object[][] generateDataSetNegative() {
		return new Object [][]{
		    new Object[] {"cantalope",'a',"ctlope","iterate"},
	    	new Object[] {"cantalope",'a',"ctlope","oneLine"}		 
		};
	}	
	
	@Test(dataProvider = "inputPositiveTesting")
	public void testUserMapping(String word,char charRemove, String result, String method){
		Assert.assertEquals(stringExample(word,charRemove, method), result);
		
	}
	@Test(dataProvider = "inputNegativeTesting")
	public void testUserMappingNeg(String word,char charRemove, String result, String method){
		Assert.assertNotEquals(stringExample(word,charRemove, method), result);
	}
		
	public String stringExample(String word, char charRemove, String method) {
		String result="";
		if(method == "iterate"){
			char[] charList = word.toCharArray();
			for(char c:charList){
			    if(c != charRemove){
			    	result = result + c;
			    }
			}
		} else if(method == "oneLine"){
			result = word.replaceAll(Character.toString(charRemove), "");
		} 
		return result;
	}
}
