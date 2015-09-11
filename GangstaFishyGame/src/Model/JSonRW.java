package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */
public class JSonRW {

	private static String filePath = "database.json";// "jsonTest.json";


	/**
	 * Read the Json file.
	 * 
	 * @return list with String(representing player name) and
	 *         integer(representing user score).
	 */
	public static List<Entry<String, Integer>> reader() {

		List<Entry<String, Integer>> result = new ArrayList<Entry<String, Integer>>();

		try {
			FileReader reader = new FileReader(getFilePath());

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray gangstaBase = (JSONArray) jsonObject.get("GangstaBase");

			Iterator i = gangstaBase.iterator();
			String tempName;
			Integer tempScore;

			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				tempName = innerObj.get("Name").toString();
				tempScore = Integer.parseInt(innerObj.get("Score").toString());

				result.add(new AbstractMap.SimpleEntry<String, Integer>(tempName, tempScore));
			}

			Collections.sort(result, new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> x, Entry<String, Integer> y) {

					return y.getValue() - x.getValue();
				}
			});

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static void writer(List<Entry<String, Integer>> list) {

		JSONObject obj = new JSONObject();
		JSONArray players = new JSONArray();

		for (Entry<String, Integer> g : list) {
			JSONObject o = new JSONObject();
			o.put("Name", g.getKey());// "Anonymous Gangsta"
			o.put("Score", g.getValue());
			players.add(o);
		}
		obj.put("GangstaBase", players);

		try {
			FileWriter file = new FileWriter(filePath);
			file.write(obj.toJSONString());


			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * get the path of the database file.
	 * 
	 * @return String giving the path of the database.
	 */
	public static String getFilePath() {
		return filePath;
	}

	/**
	 * Set the path where to find the database.
	 * 
	 * @param newFilePath
	 *            the new file path to set.
	 */
	public static void setFilePath(String newFilePath) {
		filePath = newFilePath;
	}
}
