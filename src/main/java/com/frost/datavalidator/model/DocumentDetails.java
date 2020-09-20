/**
 * 
 */
package com.frost.datavalidator.model;

import java.util.List;

import lombok.Data;

/**
 * @author jobin
 *
 */
@Data
public class DocumentDetails {

	private boolean exists;
	private String name;
	private int size;
	private String userId;
	private List<DataModel> datas;
}
