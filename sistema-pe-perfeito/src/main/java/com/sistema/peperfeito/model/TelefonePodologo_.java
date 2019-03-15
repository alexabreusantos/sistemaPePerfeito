package com.sistema.peperfeito.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TelefonePodologo.class)
public abstract class TelefonePodologo_ {

	public static volatile SingularAttribute<TelefonePodologo, Long> codigo;
	public static volatile SingularAttribute<TelefonePodologo, TipoTelefone> tipoTelefone;
	public static volatile SingularAttribute<TelefonePodologo, String> numero;
	public static volatile SingularAttribute<TelefonePodologo, Podologo> podologo;

}

