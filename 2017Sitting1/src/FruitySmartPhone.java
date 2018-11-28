import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class FruitySmartPhone extends Phone {

	private HashMap<String, Integer> installedApps = new HashMap<String, Integer>();
	private int cpuSpeed;
	private int freeMemory;

	public int getCpuSpeed() {
		return cpuSpeed;
	}

	public int getFreeMemory() {
		return freeMemory;
	}

	public FruitySmartPhone(String name, int freeMemory, int cpuSpeed) {
		// TODO Auto-generated constructor stub
		super(name);
		this.freeMemory = freeMemory;
		this.cpuSpeed = cpuSpeed;
	}

	public boolean installApp(App app) {
		// you can't install what is already there
		boolean a = installedApps.containsKey(app.getName());
		boolean b = app.getMemoryReq() > this.getFreeMemory();
		boolean c = app.getCpuReq() > this.getCpuSpeed();

		if (a || b || c) {
			return false;
		}

		installedApps.put(app.getName(), app.getMemoryReq());
		freeMemory = freeMemory - app.getMemoryReq();

		return true;
	}

	public boolean uninstallApp(App app) {
		// you can't uninstall what isn't there
		boolean a = installedApps.containsKey(app.getName());

		if (!a) {
			return false;
		}

		installedApps.remove(app.getName());
		freeMemory = freeMemory + app.getMemoryReq();
		return true;
	}
	
	public boolean useApp(String s) {
		if (!installedApps.containsKey(s) || freeMemory < 1) {
			return false;
		}
		
		freeMemory = freeMemory - 1;
		installedApps.put(s, installedApps.get(s) + 1);
		return true;
	}
	

	
	public ArrayList<String> getInstalledApps() {
		ArrayList<String> apps = new ArrayList<String>();
		ArrayList<Integer> values = new ArrayList<Integer>(installedApps.values());
		Collections.sort(values);
		Collections.reverse(values);
		
		for (int v : values) {
			for (String s : installedApps.keySet()) {
				if (apps.contains(s) == false && installedApps.get(s) == v) {
					apps.add(s); 
				}
			}
		}
	
		return apps;
	}
	
	public static void main(String[] args) {
		FruitySmartPhone p = new FruitySmartPhone("John Smith", 100, 10);
		p.installApp(new App("Camera",1,2));
		p.installApp(new App("Music",2,3));
		p.installApp(new App("Podcast",6,4));
		p.useApp("Music");
		System.out.println(p.getInstalledApps());
	}

}