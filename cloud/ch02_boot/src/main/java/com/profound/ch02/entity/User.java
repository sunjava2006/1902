package com.profound.ch02.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbUser")
public class User implements Serializable {

}
