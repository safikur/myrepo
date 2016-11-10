package com.myretail.cassandra.datasource;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraDataSource implements InitializingBean {
	protected static final Logger logger = LoggerFactory.getLogger(CassandraDataSource.class);
	private String[] contactPoints;
	private Cluster cluster;
	private Session session;

	public void afterPropertiesSet() throws Exception {
		try {
			if ((null == this.cluster) && (null == this.session)) {
				this.cluster = Cluster.builder().addContactPoints(this.contactPoints).build();
				this.session = this.cluster.connect();
			}
		} catch (Exception e) {
			throw new IllegalStateException("Execption occurred while connecting to Cassandra database", e);
		}
	}

	@PreDestroy
	public void shutdown() {
		logger.info("Shutting down the whole cassandra cluster instance");
		if (null != this.session) {
			this.session.close();
		}
		if (null != this.cluster) {
			this.cluster.close();
		}
	}

	public String[] getContactPoints() {
		return this.contactPoints;
	}

	public void setContactPoints(String[] contactPoints) {
		this.contactPoints = contactPoints;
	}

	public Cluster getCluster() {
		return this.cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
