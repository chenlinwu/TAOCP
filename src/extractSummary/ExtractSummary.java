package extractSummary;

import java.util.HashMap;



public class ExtractSummary {
//find the shortest subSequence of description containing all keyWords
	public static String extractSummary(String description,String[] keyWords) {
		String descriptionStrings[] = description.split(" ");
		int minLen=descriptionStrings.length;
		int newkeyNeeded=keyWords.length;
		HashMap<String, Integer> keyWordsCount=new HashMap<>(keyWords.length);
		for (int i = 0; i < keyWords.length; i++) {
			keyWordsCount.put(keyWords[i], 0);
		}
		
		int startPos=0,endPos=0;
		int minSP=0,minEP=0;
		String stringKey; 
		int countValue;
		//place endPos
		for(;endPos<descriptionStrings.length;endPos++){
			stringKey = descriptionStrings[endPos];
			if (keyWordsCount.containsKey(stringKey)) {
				countValue=keyWordsCount.get(stringKey);
				if (countValue==0) {
					newkeyNeeded--;
				}
				keyWordsCount.put(stringKey, ++countValue);
			}
			if (newkeyNeeded==0) {//end position is set
				//place startPos
				for(;startPos<=endPos;startPos++){
					stringKey=descriptionStrings[startPos];
					if (keyWordsCount.containsKey(stringKey)) {
						countValue=keyWordsCount.get(stringKey);
						keyWordsCount.put(stringKey, --countValue);
						if (countValue==0) {
							break;
						}
					}
				}
				if (endPos-startPos+1<minLen) {
					minLen=endPos-startPos+1;
					minSP=startPos;
					minEP=endPos;
				}
				startPos++;newkeyNeeded--;
				
			}
		}
		
		String resultString="";
		for (int i = minSP; i <=minEP; i++) {
			resultString+=" "+descriptionStrings[i];
		}

		
		return resultString;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String description = "A software developer is a person concerned with facets of the software development process A software developer may take part in design";
		String[] keyWords = {"design","in"};
		System.out.println(extractSummary(description, keyWords));

	}

}
