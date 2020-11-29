package com.aem.community.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Model(adaptables = {
		Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "AEMMaven13/components/content/imagealbum")
@Exporter(name = "jackson", extensions = { "firstservice", "secondservice" }, selector = "myselector")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JacksonExporterExample {

	@SlingObject
	Resource resource;

	@ValueMapValue
	String firstProperty;

	@ValueMapValue
	@JsonIgnore
	String secondProperty;

	@PostConstruct
	protected void init() {

		 firstProperty = "firstProperty";
		 secondProperty = "secondProperty";

/*		if (resource.getResourceMetadata().getResolutionPathInfo().contains("firstservice")) {
			firstProperty = "firstProperty";
		} else {
			secondProperty = "secondProperty";
		}*/

	}

	public String getFirstProperty() {
		return firstProperty;
	}

	public String getSecondProperty() {
		return secondProperty;
	}

}
