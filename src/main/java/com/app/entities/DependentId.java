package com.app.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class DependentId implements Serializable{
	
	private Event sportEvent;
	
}
