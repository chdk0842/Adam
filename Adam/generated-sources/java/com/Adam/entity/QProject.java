package com.Adam.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProject is a Querydsl query type for Project
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProject extends EntityPathBase<Project> {

    private static final long serialVersionUID = -1417915360L;

    public static final QProject project = new QProject("project");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final DatePath<java.sql.Date> deadLine = createDate("deadLine", java.sql.Date.class);

    public final StringPath gitLink = createString("gitLink");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath projectContent = createString("projectContent");

    public final DatePath<java.sql.Date> projectDate = createDate("projectDate", java.sql.Date.class);

    public final StringPath projectName = createString("projectName");

    public final EnumPath<com.Adam.constant.ProjectSellStatus> projectSellStatus = createEnum("projectSellStatus", com.Adam.constant.ProjectSellStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> upDateTime = _super.upDateTime;

    public QProject(String variable) {
        super(Project.class, forVariable(variable));
    }

    public QProject(Path<? extends Project> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProject(PathMetadata metadata) {
        super(Project.class, metadata);
    }

}

