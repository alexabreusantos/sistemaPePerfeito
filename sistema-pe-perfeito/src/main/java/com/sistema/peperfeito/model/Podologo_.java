package com.sistema.peperfeito.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Podologo.class)
public abstract class Podologo_ {

	public static volatile SingularAttribute<Podologo, Long> codigo;
	public static volatile SingularAttribute<Podologo, EnderecoPodologo> endereco;
	public static volatile SingularAttribute<Podologo, String> nome;
	public static volatile SingularAttribute<Podologo, Sexo> sexo;
	public static volatile SingularAttribute<Podologo, LocalDate> dataNascimento;
	public static volatile ListAttribute<Podologo, TelefonePodologo> telefones;
	public static volatile SingularAttribute<Podologo, String> email;

}

