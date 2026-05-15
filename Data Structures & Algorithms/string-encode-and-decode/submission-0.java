class Solution {
    public String encode(List<String> strs) {
    var encodedStringBuilder = new StringBuilder();
    strs.forEach(str -> encodedStringBuilder.append(str.length())
            .append('#').append(str));
    return encodedStringBuilder.toString();
}

public List<String> decode(String str) {
    Pattern numberAndHashtag = Pattern.compile("(\\d+)#");
    Matcher matcher = numberAndHashtag.matcher(str);
    var result = new ArrayList<String>();
    int i = 0;
    while (matcher.find(i)) {
        var number = matcher.group(1);
        var startIndex = matcher.end();
        var endIndex = startIndex + Integer.parseInt(number);
        result.add(str.substring(startIndex, endIndex));
        i = endIndex;
    }
    return result;
}
}
