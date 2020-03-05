package Contest178;

import java.util.Arrays;

public class RankTeamsByVotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String rankTeams(String[] votes) {
        int[][] v = new int[26][26];
        for (int i = 0; i < votes[0].length(); ++i) {
            for (String w : votes) {
                v[i][w.charAt(i)-'A']++;
            }
        }
        String[] vs = new String[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                vs[i] += " " + String.format("%04d", v[j][i]);
            }
            vs[i] += " " + (char)(((int)'Z')-i);
        }
        Arrays.sort(vs);
        String ans = "";
        for (int i = 0; i < votes[0].length(); ++i) {
            ans += (char)((int)('Z'-vs[25-i].charAt(vs[25-i].length()-1))+(int)'A');
        }
        return ans;
    }

}
