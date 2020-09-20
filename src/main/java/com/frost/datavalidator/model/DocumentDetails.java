/**
 * 
 */
package com.frost.datavalidator.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * @author jobin
 *
 */
@Data
@Builder
public class DocumentDetails {

	private boolean exists;
	private String name;
	private String type;
	private int size;
	private String userId;
	private List<DataModel> datas;
}
