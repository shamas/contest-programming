import java.util.ArrayList;

public class StringCoder {
	private String masterString;
	public StringCoder(String master){
		masterString = master;
	}
	public String decodeString(ArrayList<StringPart> parts){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < parts.size(); ++i){
			StringPart part = parts.get(i);
			sb.append(masterString.subSequence(part.start, part.getStart() + part.getLength()));
		}
		return sb.toString();
	}
	private StringPart findPart(String str){
		int index = masterString.indexOf(str);
		return new StringPart(index, index + str.length());
	}
	public ArrayList<StringPart> encodeString(String word){
		ArrayList<StringPart> part = new ArrayList<StringPart>();
		while(word.length() > 0){
			for(int i = word.length(); i > 0; --i){
				String n = word.substring(0, i);
				if(masterString.contains(n)){
					StringPart p = findPart(n);
					part.add(p);
					word = word.substring(n.length());
					break;
				}
			}
		}
		return part;
	}
}
