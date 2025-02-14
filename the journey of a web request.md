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
  
### Performance Impact

- **Cache Hits:** The closer the cache layer, the faster the resolution. For example, a hit in the browser cache is the fastest.
- **Cache Miss:** If no cache layer has the IP address, the query goes through the full DNS hierarchy, increasing latency.
- **TTL (Time To Live):** DNS records have a TTL value that determines how long they are cached. Short TTLs lead to more frequent cache misses.

## 2. Establishing TCP Connection
Establishing TCP Connection
When a browser initiates communication with a web server, it establishes a TCP (Transmission Control Protocol) connection to ensure reliable, ordered data transmission. This process consists of several key steps.

TCP Three-Way Handshake
The connection setup follows a three-way handshake, ensuring both client and server synchronize before data transmission begins:

1.SYN (Synchronize)
The client sends a SYN packet to the server, requesting a connection.
The packet includes an Initial Sequence Number (ISN) to track transmitted data.

2.SYN-ACK (Synchronize-Acknowledge)
The server responds with a SYN-ACK packet, acknowledging the client's request.
It also sends its own ISN to synchronize communication.

3.ACK (Acknowledge)
The client responds with an ACK packet, confirming the connection is established.
Data transfer begins.

Example of Three-Way Handshake:
Client → Server: SYN (ISN=1000)
Server → Client: SYN-ACK (ISN=5000, ACK=1001)
Client → Server: ACK (ACK=5001)

<!-- **TODO:** Complete the three-way handshake-->
### Three-Way Handshake Process

The three-way handshake is a process that establishes a reliable connection between the client and server before the data transmission in three steps:

**1. SYN (Synchronize)**
- The client sends a **SYN** (synchronize) packet to the server.
- This packet contains an initial sequence number.
- It indicates that the client wants to establish a connection and synchronize sequence numbers.

**2. SYN-ACK (Synchronize-Acknowledgment)**
- The server receives the SYN packet and responds with a **SYN-ACK** packet.
- Two purposes are served via the SYN-ACK packet:
  - It acknowledges the client's SYN request.
  - It also includes the server's own initial sequence number to synchronize communication.

**3. ACK (Acknowledgment)**
- The client receives the SYN-ACK packet and responds with an **ACK** packet.
- This ACK packet acknowledges the server's sequence number.
- Once the server receives this ACK, the TCP connection is established, and data transfer can begin.
  
![Image](https://github.com/user-attachments/assets/fc0d308f-6a00-46a5-acdd-7cad310ec442)


TCP Window Sizing and Flow Control:
TCP uses window sizing to manage how much data can be sent before receiving an acknowledgment, preventing network congestion and overwhelming the receiver.

1. TCP Sliding Window Mechanism
Each sender and receiver maintain a window size, indicating how much unacknowledged data can be in transit.
The receiver advertises a window size (Receiver Window, rwnd) to inform the sender of its available buffer space.
The sender adjusts the amount of data sent to avoid overwhelming the receiver.
2. Bandwidth-Delay Product (BDP)
The ideal window size is calculated based on network bandwidth and Round-Trip Time (RTT):
𝐵𝐷𝑃 = Bandwidth × RTT

A properly tuned window size improves throughput by maximizing link utilization.


Congestion Control Algorithms :
TCP congestion control mechanisms help prevent excessive packet loss and network congestion. The most widely used algorithm is AIMD (Additive Increase Multiplicative Decrease), which dynamically adjusts the transmission rate based on network conditions.

1. Additive Increase Phase (AI)
When no congestion is detected, TCP gradually increases the congestion window (cwnd) to maximize throughput.
The increase is linear, meaning TCP adds 1 Maximum Segment Size (MSS) per RTT.

2. Multiplicative Decrease Phase (MD)
When packet loss occurs (indicating congestion), TCP halves the congestion window (cwnd) to quickly reduce network load.
This exponential reduction helps prevent congestion collapse.

3. Phases of Congestion Control
Slow Start:
TCP starts with a small cwnd and increases it exponentially to quickly probe available bandwidth.
Congestion Avoidance:
Once a threshold is reached, growth shifts to linear (Additive Increase) to prevent network overload.
Fast Retransmit & Fast Recovery:
If 3 duplicate ACKs are received, TCP retransmits lost packets without waiting for a timeout.


How These Mechanisms Manage Data Flow & Congestion :
1.Prevents buffer overflow: The receiver’s advertised window (rwnd) ensures that the sender does not overwhelm it.
2.Optimizes bandwidth usage: Sliding window and BDP tuning maximize throughput efficiency.
3.Avoids congestion collapse: AIMD dynamically adjusts sending rates based on network conditions.
4.Maintains fairness: Multiplicative decrease ensures all network users get a fair share of bandwidth.



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

Browser Rendering Pipeline:
Once the browser receives the response, it processes and renders the page in these key steps:

1.Parsing HTML
The browser converts HTML into a DOM (Document Object Model).
HTML is processed in a tree structure where each element becomes a node.

2.Building the CSSOM (CSS Object Model)
CSS files are downloaded and parsed separately.
The CSSOM tree is created to apply styles correctly.

3.Render Tree Construction
The DOM and CSSOM trees are combined to form the Render Tree.
This tree only contains elements that need to be displayed (hidden elements like <display: none> are excluded).

4.Layout (Reflow)
The browser calculates the exact position and size of elements based on styles and viewport size.
Elements are arranged as per CSS rules like position, flex, grid, etc.

5.Painting
The browser converts pixels into visual elements by applying colors, backgrounds, shadows, and text.

6.Compositing
The browser optimizes the rendering by breaking the page into layers and combining them efficiently to minimize repainting

How the Browser Decides What to Render First:
To ensure a fast and smooth experience, the browser prioritizes:

1.Above-the-Fold Content → Elements visible without scrolling are rendered first.
2.Critical Resources → HTML and CSS are parsed early, while JavaScript execution is deferred if marked with async or defer.
3.Efficient Layering → Complex elements (e.g., animations) are placed in GPU-accelerated layers for smooth rendering.

Critical Rendering Path (CRP):
The Critical Rendering Path (CRP) is the sequence of steps the browser follows to render the first meaningful paint of a webpage. Optimizing it improves performance and load times.

Steps in the Critical Rendering Path:
1.HTML Parsing & DOM Creation → The browser parses HTML to construct the DOM.
2.CSS Parsing & CSSOM Creation → CSS is parsed separately into the CSSOM.
3.JavaScript Execution → Scripts may modify the DOM or CSSOM, affecting rendering.
4.Render Tree Construction → The DOM + CSSOM merge, excluding display: none elements.
5.Layout (Reflow) → The browser calculates positions and dimensions of elements.
6.Painting & Compositing → The page is drawn and layered for rendering efficiency.

Why CRP Matters?
A well-optimized CRP ensures:
 Faster page load times 
 Better user experience 
 Lower resource consumption 









## Common Optimization Techniques
- Content Delivery Networks (CDNs)
- Browser caching
- Compression
- Connection pooling

**TODO:** Add space and time complexity analysis for different caching strategies

## Error Scenarios
- **TODO:**Complete the error scenarios

## Security Considerations
Security Considerations:
Ensuring security in web applications is critical to protecting user data and maintaining system integrity. The web request process is vulnerable to several common security threats, including Cross-Site Scripting (XSS), Cross-Site Request Forgery (CSRF), and SQL Injection. Proper security measures should be implemented to mitigate these risks and ensure secure user interactions.

Common Security Vulnerabilities and Their Prevention:

1.Cross-Site Scripting (XSS)
XSS attacks occur when an attacker injects malicious scripts into web pages viewed by users. This can lead to data theft, session hijacking, and website defacement.

How XSS Works:
The attacker injects a malicious script into a website, which is then executed by a victim's browser.
The script can steal cookies, redirect users to phishing sites, or manipulate webpage content.

Example of XSS:
Consider an input field that accepts user comments and displays them without sanitization:
<input type="text" name="comment" value="<script>alert('Hacked!');</script>">

If the application does not sanitize this input, the script will execute when another user views the page.

Prevention:
1.Sanitize and validate all user inputs to ensure they do not contain malicious scripts.
2.Use Content Security Policy (CSP) headers to limit the execution of unauthorized scripts.
3.Encode output properly to prevent untrusted input from being executed as code in the browser.

2.Cross-Site Request Forgery (CSRF):
CSRF attacks trick authenticated users into unknowingly executing unwanted actions on a web application in which they are logged in.

How CSRF Works:
The attacker crafts a malicious request and tricks a logged-in user into executing it, leveraging their authentication session.
The action is performed without the user’s consent, potentially leading to unauthorized transactions or data changes.

Example of CSRF:
A forged request hidden in an email or malicious website:
<img src="https://example.com/transfer?amount=1000&to=attacker" />
If the user is logged into their bank account, this request may transfer funds without their knowledge.

Prevention:
Implement CSRF tokens to validate legitimate user requests.

Require user authentication for sensitive actions and verify user intent via re-authentication.

Use the SameSite attribute in cookies to prevent unauthorized cross-origin requests.

3.SQL Injection:
SQL Injection occurs when an attacker manipulates an application's SQL queries by injecting malicious SQL statements, potentially leading to unauthorized data access, database compromise, or even data deletion.

How SQL Injection Works:
Attackers insert or modify SQL queries through user input fields to execute arbitrary SQL commands.
This can allow them to retrieve sensitive data, modify database records, or even execute administrative operations.

Example of SQL Injection:
Consider a vulnerable login query:
SELECT * FROM users WHERE username = 'admin' AND password = '" + userInput + "'";

If an attacker enters password' OR '1'='1, the query becomes:
SELECT * FROM users WHERE username = 'admin' AND password = '' OR '1'='1';
Since 1=1 always evaluates to true, the attacker gains access without a valid password.

Prevention:
Use parameterized queries and prepared statements to prevent SQL code from being executed as part of user input.

Validate and sanitize all input fields to ensure they conform to expected formats.

Implement least-privilege access for database users to minimize the impact of a potential breach.

Use Web Application Firewalls (WAFs) to detect and block SQL injection attempts.

Additional Security Measures :

1.SSL/TLS Encryption:
Secure Sockets Layer (SSL) and Transport Layer Security (TLS) encrypt data transmitted between the client and the server, ensuring confidentiality and integrity.

Importance of SSL/TLS:
Protects sensitive user data (such as login credentials and payment details) from interception.

Prevents man-in-the-middle (MITM) attacks by ensuring encrypted communication.

Helps in maintaining user trust by displaying the secure padlock symbol in the browser.

Best Practices:
Enforce HTTPS to prevent data interception and MITM attacks.

Use strong cryptographic algorithms and keep certificates up to date.

Enable HTTP Strict Transport Security (HSTS) to enforce secure connections.

2.Input Validation:
Validating input ensures that user-provided data adheres to expected formats, reducing the risk of attacks such as XSS, SQL Injection, and buffer overflow exploits.

Importance of Input Validation:
Prevents injection attacks by rejecting unexpected input.

Reduces errors and improves application stability.

Ensures data integrity by only accepting properly formatted input.

Best Practices:
Use server-side validation alongside client-side validation to prevent malicious input.

Define strict rules for acceptable input formats using allowlists.

Implement automated security testing to detect and remediate input vulnerabilities.

3.Session Management:
Proper session management is essential to maintaining user authentication and preventing session-related attacks.

Importance of Session Management:
Prevents unauthorized access by securely handling session tokens.

Protects against session fixation and session hijacking attacks.

Ensures secure user authentication and session lifecycle control.

Best Practices:
Use secure and random session tokens to prevent session fixation and hijacking.

Set session expiration and automatically log out inactive users.

Store session identifiers securely and restrict access via secure cookies.

Implement multi-factor authentication (MFA) for added security.

By implementing these security measures, web applications can significantly reduce their exposure to common attacks, protecting both users and system data from exploitation.


---

This document provides a high-level overview of how web requests work. Several sections marked with **TODO** need additional details and technical depth. Contributions are welcome!
