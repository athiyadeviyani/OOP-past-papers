import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

class SnowSquirrelBrowser extends Browser {

	private HashMap<String, Double> installedPlugins = new HashMap<String, Double>();
	private String version;
	private double availableQuota;

	public String getVersion() {
		return version;
	}

	public double getAvailableQuota() {
		return availableQuota;
	}

	public SnowSquirrelBrowser(String name, double availableQuota, String version) {
		super(name);
		this.availableQuota = availableQuota;
		this.version = version;
	}

	public boolean installPlugin(Plugin plugin) {
		// falsifiers
		// already installed
		boolean a = installedPlugins.containsKey(plugin.getName());
		// requires more cloud quota than available
		boolean b = plugin.getQuotaReq() > this.getAvailableQuota();
		// does not match the version required by the plugin exactly
		boolean c = !plugin.getVersionReq().equals(this.getVersion());

		if (a || b || c) {
			return false;
		}

		installedPlugins.put(plugin.getName(), plugin.getQuotaReq());
		availableQuota = availableQuota - plugin.getQuotaReq();
		return true;
	}

	public boolean uninstallPlugin(Plugin plugin) {
		// falsifier
		// plugin is not installed
		if (!(installedPlugins.containsKey(plugin.getName()))) {
			return false;
		}
		installedPlugins.remove(plugin.getName());
		availableQuota = availableQuota + plugin.getQuotaReq();
		return true;
	}

	public boolean usePlugin(String pluginName) {
		// falsifiers
		// plugin not installed
		boolean a = !installedPlugins.containsKey(pluginName);
		// insufficient memory
		boolean b = getAvailableQuota() < 1;

		if (a || b) {
			return false;
		}

		availableQuota = availableQuota - 1;
		installedPlugins.put(pluginName, installedPlugins.get(pluginName) + 1);
		return true;
	}

	public ArrayList<String> getInstalledPlugins() {
//		ArrayList<String> result = new ArrayList<String>();
//		Map<String,Double> trial = new TreeMap<String,Double>(installedPlugins);
//		
//		
//		for (Entry<String, Double> entry : trial.entrySet())  {
////            System.out.println("Key = " + entry.getKey() + 
////                         ", Value = " + entry.getValue());    
//            result.add(entry.getKey());
//    	}
//	
////		for (String pluginName : trial.keySet()) {
////			System.out.println(pluginName + trial.get(pluginName));
////			result.add(pluginName);
////		}
//		
//		Collections.reverse(result);
//		return result;
		
		ArrayList<String> plugins = new ArrayList<String>();
		ArrayList<Double> values = new ArrayList<Double>(installedPlugins.values());
		Collections.sort(values);
		Collections.reverse(values);
		
		for (Double v : values) {
			for (String s : installedPlugins.keySet()) {
				if (plugins.contains(s) == false && installedPlugins.get(s) == v) {
					plugins.add(s);
				}
			}
		}
	
		return plugins;
	}
	
	public static void main(String[] args) {
		SnowSquirrelBrowser s = new SnowSquirrelBrowser("John Smith", 10, "1.0");
		s.installPlugin(new Plugin("Shopping",2.0,"1.0"));
		s.installPlugin(new Plugin("VPN",3.0,"1.0"));
		s.installPlugin(new Plugin("Email",2.0,"2.0"));
		s.usePlugin("VPN");
		System.out.println(s.getInstalledPlugins());
		
		
	}

}
