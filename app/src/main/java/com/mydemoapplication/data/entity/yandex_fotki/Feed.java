package com.mydemoapplication.data.entity.yandex_fotki;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;
@Root
@Namespace(prefix = "f",reference="yandex:fotki")
public class Feed implements Serializable{

//	@ElementList(inline = true, required = false)
//	private List<Link> links;
//	@Element
//	private String id;
    @Element
	private String title;
//	@Element
//	private String updated;
	@ElementList(inline = true, required = false)
    private List<Entry> entry;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Entry> getEntry() {
		return entry;
	}

	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}
}
    