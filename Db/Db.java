package w0724;

public abstract class Db<K, V> {
	protected String ip;
	protected int port;

	public Db() {
	}

	public Db(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void connect() {
		System.out.println(ip + " Connection");
	}

	public void close() {
		System.out.println(ip + " Closed");
	}

	public abstract void insert(V v) throws Exception;

	public abstract void update(V v) throws Exception;

	public abstract void delete(K k) throws Exception;
}
