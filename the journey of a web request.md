# The Journey of a Web Request

When you type a URL in your browser and press Enter, a fascinating journey begins. Let's break down this journey step by step.

## 1. DNS Resolution
- The browser first needs to find the actual IP address of the server
- It checks various DNS caches (browser, operating system, router)
- If not found in caches, it queries DNS servers
- Finally gets the IP address of the server

<!-- **TODO:** Add explanation of DNS cache hierarchy and time complexity of DNS lookups -->
### DNS Cache Hierarchy

DNS resolution involves multiple layers of caching. Each layer in the DNS cache hierarchy is checked sequentially, ensuring the fastest 
possible resolution by retrieving the IP address from the closest available cache.

Here is the working of the hierarchy-

**1. Browser Cache**
- The browser is the first place checked for a cached DNS entry. Browsers store DNS records for previously visited domains.
- This cache reduces the need for repetitive DNS lookups, enhancing performance.
- Time Complexity - O(1)
  
**2. Operating System (OS) Cache**
- If the IP address isn't found in the browser cache, the operating system's DNS cache is checked.
- The OS maintains the local cache of the DNS records retrieved by all the applications, including the browsers.
- Time Complexity - O(1)

**3. Router Cache**
 - If the IP address is not in the OS cache, the query is sent to the local router.
 - Many modern routers cache DNS records to speed up requests from devices on the same network.
 - Time Complexity - O(1)

**4. DNS Resolver Cache**
- If the OS cache doesn't have the record, the query is sent to the Recursive DNS Resolver Cache, usually managed by the ISP or a third-party provider (e.g. Google DNS).
- Time Complexity - O(1)
  
**5. Authoritative DNS Server**
-  If the DNS server does not contain the requested DNS record, the resolver queries the authoritative DNS server for the domain.
-  The authoritative DNS server provides the definitive IP address for the requested domain.
-  Time Complexity: O(n) where n is the number of hierarchical DNS servers queried
- 
### Performance Impact

- **Cache Hits:** The closer the cache layer, the faster the resolution. For example, a hit in the browser cache is the fastest.
- **Cache Miss:** If no cache layer has the IP address, the query goes through the full DNS hierarchy, increasing latency.
- **TTL (Time To Live):** DNS records have a TTL value that determines how long they are cached. Short TTLs lead to more frequent cache misses.

## 2. Establishing TCP Connection
- The browser initiates a TCP connection with the server
- This happens through the famous three-way handshake:
  - **TODO:**Complete the three-way handshake

**TODO:** Add details about TCP window sizing and congestion control algorithms

## 3. TLS Handshake (for HTTPS)
- After TCP connection, a secure channel needs to be established
- Client and server exchange certificates
- They negotiate encryption algorithms
- A secure connection is established

## 4. HTTP Request Formation
- Browser creates an HTTP request with the following components:
# HTTP Request Components

## HTTP Methods
HTTP methods define the intended action for a request:

### GET
- Retrieves resources from the server
- Cannot include a request body
- Data sent through URL parameters only
- Example: `GET /api/products`

### POST
- Submits data to create new resources
- Includes data in request body
- Example: `POST /api/users`

### PUT
- Updates existing resources completely
- Includes full resource in body
- Example: `PUT /api/users/123`

### DELETE
- Removes specified resources
- Typically no body needed
- Example: `DELETE /api/users/123`

## Headers
Headers provide essential metadata for request processing:

### Common Request Headers
- Host: Target host and port number
- Content-Type: Format of sent data
- Content-Length: Size of request body
- Authorization: Authentication credentials
- Accept: Expected response formats
- User-Agent: Client application info
- Cookie: Session data

Example header set:
```
Host: api.example.com
Content-Type: application/json
Content-Length: 128
Authorization: Bearer <token>
```

## Request Body
The body carries data in various formats based on Content-Type:

### Types
1. application/json
   - Structured data in JSON format
   - Used for API requests

2. application/x-www-form-urlencoded
   - Simple key-value pairs
   - Default for HTML forms

3. multipart/form-data
   - File uploads
   - Mixed content types

## URL Parameters
Query parameters in the URL for data transmission:

### Structure
- Start with question mark (?)
- Use key=value format
- Join multiple parameters with ampersand (&)
- Must be URL-encoded

Example: `/search?query=term&category=books&page=1`

## 5. Server Processing
- Request arrives at the server
- Server routes the request to appropriate handler
- Application logic processes the request
- Database queries may be executed
- Response is generated

## 6. Response Journey
- Server sends HTTP response
- **TODO:**Complete the response journey
- Data travels back through the network

## 7. Browser Processing
- Browser receives the response
- If HTML, begins parsing
- Downloads additional resources (CSS, JS, images)
- Renders the page

**TODO:** Add details about browser rendering pipeline and critical rendering path

## Common Optimization Techniques
- Content Delivery Networks (CDNs)
- Browser caching
- Compression
- Connection pooling

**TODO:** Add space and time complexity analysis for different caching strategies

## Error Scenarios
- **TODO:**Complete the error scenarios

## Security Considerations
- **TODO:**Complete the security considerations

**TODO:** Add detailed explanation of common security vulnerabilities and prevention techniques

---

This document provides a high-level overview of how web requests work. Several sections marked with **TODO** need additional details and technical depth. Contributions are welcome!
