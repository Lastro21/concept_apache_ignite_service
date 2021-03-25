package ru.sbrf.fullkeeper;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;

import java.util.Arrays;

@SpringBootApplication
public class FullkeeperApplication {

    public static void main(String[] args) {

        SpringApplication.run(FullkeeperApplication.class, args);

        TcpDiscoverySpi spi = new TcpDiscoverySpi();

        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();

        ipFinder.setAddresses(Arrays.asList("10.53.123.84", "10.53.123.54:47500..47509"));

        spi.setIpFinder(ipFinder);

        IgniteConfiguration cfg = new IgniteConfiguration();

        cfg.setDiscoverySpi(spi);

        Ignite ignite = Ignition.start(cfg);

        IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");

        cache.put(1, "Hello World 1");
        cache.put(2, "Hello World 2");
        cache.put(3, "Hello World 3");
        cache.put(4, "Hello World 4");
        cache.put(5, "Hello World 5");
        cache.put(6, "Hello World 6");
        cache.put(7, "Hello World 7");
        cache.put(8, "Hello World 8");
        cache.put(9, "Hello World 9");

        System.out.println("Cache size = " + cache.size());


    }

}
