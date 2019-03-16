package com.sistema.peperfeito.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ {

	public static volatile SingularAttribute<Paciente, Long> codigo;
	public static volatile SingularAttribute<Paciente, Endereco> endereco;
	public static volatile SingularAttribute<Paciente, String> nome;
	public static volatile SingularAttribute<Paciente, Sexo> sexo;
	public static volatile SingularAttribute<Paciente, LocalDate> dataNascimento;
	public static volatile ListAttribute<Paciente, TelefonePaciente> telefones;
	public static volatile SingularAttribute<Paciente, String> email;

}

