package com.sistema.peperfeito.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TelefonePaciente.class)
public abstract class TelefonePaciente_ {

	public static volatile SingularAttribute<TelefonePaciente, Long> codigo;
	public static volatile SingularAttribute<TelefonePaciente, TipoTelefone> tipoTelefone;
	public static volatile SingularAttribute<TelefonePaciente, String> numero;
	public static volatile SingularAttribute<TelefonePaciente, Paciente> paciente;

}

