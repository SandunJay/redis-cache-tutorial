<h1>Redis Cache Tutorial with Java</h1>

<p>This tutorial demonstrates how to integrate <strong>Redis Cache</strong> into a Java application, providing efficient caching mechanisms to improve application performance. Redis is an open-source, in-memory key-value store that offers powerful caching capabilities and supports various data structures.</p>

<h2>Overview</h2>
<p>In this tutorial, we will build a simple Java application that connects to a Redis server to demonstrate basic caching operations. You will learn how to:</p>
<ul>
  <li>Set up a Redis server.</li>
  <li>Integrate Redis with a Java application using the <code>Jedis</code> library.</li>
  <li>Implement basic caching operations such as <strong>set</strong>, <strong>get</strong>, and <strong>expire</strong> in Redis.</li>
  <li>Use Redis to cache frequently accessed data, reducing database load and improving response time.</li>
</ul>

<h2>Technologies Used</h2>
<ul>
  <li><strong>Java</strong>: Primary programming language.</li>
  <li><strong>Redis</strong>: In-memory data store used for caching.</li>
  <li><strong>Jedis</strong>: Java Redis client library.</li>
  <li><strong>Maven</strong>: Build automation tool.</li>
  <li><strong>Spring Boot</strong> (Optional): For demonstrating caching in web applications.</li>
</ul>

<h2>File Structure</h2>
<pre><code>
redis-cache-tutorial/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/redis/  # Application files
│   │   └── resources/
│   │       └── application.properties  # Spring Boot configuration file
├── pom.xml  # Maven configuration file
└── README.md
</code></pre>

<h2>Prerequisites</h2>
<ul>
  <li><strong>Java</strong> (>= 8)</li>
  <li><strong>Redis</strong> (>= 6.0) - You can install Redis locally or use a managed Redis service.</li>
  <li><strong>Maven</strong> (>= 3.6)</li>
</ul>

<h2>Getting Started</h2>

<h3>Step 1: Set up Redis</h3>
<ul>
  <li>Install Redis locally by following instructions from the <a href="https://redis.io/download">Redis website</a>.</li>
  <li>Alternatively, use a managed Redis service like <strong>Amazon ElastiCache</strong> or <strong>Redis Cloud</strong>.</li>
  <li>Once installed, start Redis using the command:</li>
</ul>
<pre><code>redis-server</code></pre>

<h3>Step 2: Create a Java Project</h3>
<ul>
  <li>Create a new Java project using <strong>Maven</strong>. You can use the following command:</li>
</ul>
<pre><code>mvn archetype:generate -DgroupId=com.example -DartifactId=redis-cache-tutorial -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false</code></pre>

<h3>Step 3: Add Dependencies</h3>
<p>In the <code>pom.xml</code> file, add the necessary dependencies for <strong>Jedis</strong>:</p>
<pre><code>
&lt;dependencies&gt;
    &lt;!-- Jedis Redis client --&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;redis.clients&lt;/groupId&gt;
        &lt;artifactId&gt;jedis&lt;/artifactId&gt;
        &lt;version&gt;4.0.0&lt;/version&gt;
    &lt;/dependency&gt;

    &lt;!-- Spring Boot (Optional for Web Applications) --&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter&lt;/artifactId&gt;
        &lt;version&gt;2.7.3&lt;/version&gt;
    &lt;/dependency&gt;
&lt;/dependencies&gt;
</code></pre>

<h3>Step 4: Write Redis Cache Code</h3>
<p>Create a new Java class, <code>RedisCacheExample.java</code>, to implement Redis caching operations:</p>

<pre><code>
package com.example.redis;

import redis.clients.jedis.Jedis;

public class RedisCacheExample {

    public static void main(String[] args) {
        // Connect to Redis server
        Jedis jedis = new Jedis("localhost", 6379);
        
        // Set a value in Redis
        jedis.set("exampleKey", "Hello, Redis!");
        
        // Get a value from Redis
        String value = jedis.get("exampleKey");
        System.out.println("Cached Value: " + value);
        
        // Set an expiration time for the key
        jedis.expire("exampleKey", 30);  // Expires in 30 seconds
        
        // Close the connection
        jedis.close();
    }
}
</code></pre>

<h3>Step 5: Run the Application</h3>
<ul>
  <li>Ensure that the Redis server is running on <code>localhost:6379</code>.</li>
  <li>Compile and run the application using Maven:</li>
</ul>
<pre><code>mvn clean compile exec:java -Dexec.mainClass="com.example.redis.RedisCacheExample"</code></pre>
<p>You should see output displaying the cached value:</p>
<pre><code>Cached Value: Hello, Redis!</code></pre>

<h2>Using Redis with Spring Boot (Optional)</h2>
<p>If you're building a web application, you can integrate Redis as a cache provider with <strong>Spring Boot</strong>. Update your <code>application.properties</code> with Redis configurations:</p>

<pre><code>
spring.redis.host=localhost
spring.redis.port=6379
</code></pre>

<p>Then, use the <code>@Cacheable</code> annotation to cache method responses:</p>

<pre><code>
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Cacheable("data")
    public String fetchData() {
        // Simulate a slow process
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Cached Data";
    }
}
</code></pre>

<h2>Common Redis Operations</h2>
<ul>
  <li><strong>Set a value</strong>: <code>jedis.set(key, value)</code></li>
  <li><strong>Get a value</strong>: <code>jedis.get(key)</code></li>
  <li><strong>Delete a value</strong>: <code>jedis.del(key)</code></li>
  <li><strong>Set expiration</strong>: <code>jedis.expire(key, seconds)</code></li>
  <li><strong>Check if key exists</strong>: <code>jedis.exists(key)</code></li>
</ul>

<h2>Conclusion</h2>
<p>This tutorial demonstrates the basics of integrating Redis Cache into a Java application using <strong>Jedis</strong>. Caching can significantly improve the performance of your applications by reducing the load on your database and speeding up data retrieval.</p>

<h2>Contributing</h2>
<p>Contributions are welcome! Please fork the repository, create a new branch, and submit a pull request.</p>

<h2>License</h2>
<p>This project is licensed under the MIT License - see the <a href="LICENSE">LICENSE</a> file for details.</p>
