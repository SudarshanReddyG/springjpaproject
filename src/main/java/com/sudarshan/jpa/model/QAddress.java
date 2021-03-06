package com.sudarshan.jpa.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QAddress extends BeanPath<Address> {

    private static final long serialVersionUID = 2099208790L;

    public static final QAddress address = new QAddress("address");

    public final StringPath country = createString("country");

    public final StringPath postCode = createString("postCode");

    public final StringPath postOffice = createString("postOffice");

    public final StringPath state = createString("state");

    public final StringPath streetAddress = createString("streetAddress");

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata<?> metadata) {
        super(Address.class, metadata);
    }

}

