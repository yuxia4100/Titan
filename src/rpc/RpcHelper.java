package rpc;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Item;

public class RpcHelper {
	public static JSONObject readJsonObject(HttpServletRequest request) {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
				//System.out.println("this line is " + line);
			}
			reader.close();
			if (!jb.toString().equals("")) {
				//System.out.println(jb.toString());
				return new JSONObject(jb.toString());
			} else {
				//System.out.println("Your request isn't a JSON format!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Writes a JSONObject to http response.
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
		try {
			response.setContentType("application/json");
			response.addHeader("Access-Control-Allow-Origin", "*");
			PrintWriter out = response.getWriter();
			out.print(array);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Converts a list of Item objects to JSONArray.
		public static JSONArray getJSONArray(List<Item> items) {
			JSONArray result = new JSONArray();
			try {
				for (Item item : items) {
					result.put(item.toJSONObject());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

	
}
