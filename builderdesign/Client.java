package in.cdac.builderdesign;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Query q=Query.getBuilder()
				      .setFrom("production")
				      .setSelect("select *")
				      .build();

	}

}
