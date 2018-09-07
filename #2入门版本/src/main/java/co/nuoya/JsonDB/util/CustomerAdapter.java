package co.nuoya.JsonDB.util;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.model.Tags;

public class CustomerAdapter extends TypeAdapter<Customer> {

	@Override
	public void write(JsonWriter out, Customer value) throws IOException {
		value.toString();//触发懒加载
		out.beginObject();
		out.name("_id").value(value.getId());
		out.name("index").value(value.getIndex());
		out.name("guid").value(value.getGuid());
		out.name("isActive").value(value.isActive());
		
		//acount是一个对象
		out.name("acount").beginObject();
		out.name("acount_id").value(value.getAccout().getAcount_id());
		out.name("balance").value(value.getAccout().getBalance());
		//out.name("created").value(StringUtils.toString(value.getAccout().getCreated()));
		out.name("createdby").value(value.getAccout().getCreatedby());
		//out.name("update").value(StringUtils.toString(value.getAccout().getUpdate()));
		out.name("updateby").value(value.getAccout().getUpdateby());
		out.endObject();
		
		out.name("picture").value(value.getPicture());
		out.name("age").value(value.getAge());
		out.name("eyeColor").value(value.getEyecolor());
		out.name("lastName").value(value.getLastName());
		out.name("company").value(value.getCompany());
		out.name("email").value(value.getEmail());
		out.name("phone").value(value.getPhone());
		out.name("address").value(value.getAddress());
		out.name("about").value(value.getAbout());
		
		//tags是一个集合
		out.name("tags").beginArray();
		for( final Tags tag : value.getTags()) {
			out.beginObject();
			out.name("id").value(tag.getId());
			out.name("customer_id").value(tag.getCustomer_id());
			out.name("tag").value(tag.getTag());
			//out.name("created").value(tag.getCreated());
			out.name("createdby").value(tag.getCreatedby());
			//out.name("update").value(tag.getUpdate());
			out.name("updateby").value(tag.getUpdateby());
			out.endObject();
		}
		out.endArray();
		
		out.name("favoriteFruit").value(value.getFavoriteFruit());
		//out.name("created").value(value.getCreated());
		out.name("createdby").value(value.getCreatedby());
		//out.name("update").value(value.getUpdate());
		out.name("updateby").value(value.getUpdateby());
		
		out.endObject();//如果没有调用 out.endObject(),会报出 JsonSyntaxException错误
	}

	@Override
	public Customer read(JsonReader in) throws IOException {
		final Customer customer = new Customer();
		
		in.beginObject();
		while(in.hasNext()) {
			switch(in.nextName()) {
			case "_id" :
				customer.setId(in.nextString());
				break;
			case "index" :
				customer.setIndex(in.nextString());
				break;
			case "guid" :
				customer.setGuid(in.nextString());
				break;
			case "isActive" :
				customer.setActive(in.nextBoolean());
				break;
			}
		}
		in.endObject();
		
		return customer;
	}

}
