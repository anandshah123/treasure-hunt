package com.github.treasurehunt;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

@Configuration
public class MonitoringConfig {

    @Autowired
    private MetricRegistry registry;

    @Value("${graphite.reporter.host:localhost}")
    private String graphiteReporterHost;

    @Value("${graphite.reporter.port:2003}")
    private int graphiteReporterPort;

    @Bean
    public GraphiteReporter graphiteReporter() {
        Graphite graphite = new Graphite(new InetSocketAddress(graphiteReporterHost, graphiteReporterPort));
        GraphiteReporter reporter = GraphiteReporter.forRegistry(registry)
                .prefixedWith("boot").build(graphite);
        reporter.start(500, TimeUnit.MILLISECONDS);
        return reporter;
    }
}
