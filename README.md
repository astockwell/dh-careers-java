dh-careers-java
===============

First [Play](https://www.playframework.com/) Project: Careers Site with React.js

The Java app scrapes Dignity's [IT Careers](http://dignityhealth.org/careers/jobs/index.php?do=search&category=Information+Technology+%28IT%29&location=) pages, parses the HTML for the actual jobs details (which I'm calling the "jobs manifest"), then provides a javascript object with the resulting manifest, and builds a webpage with a filterable, sortable, paginated table for the user. Powered by [React.js](http://facebook.github.io/react/index.html) and [Reactable](http://glittershark.github.io/reactable/).

## To Run

1. Run `vagrant up`
2. Run `make`
3. Visit `localhost:9000`

Or just visit [astockwell.github.io/dh-careers-java](http://astockwell.github.io/dh-careers-java)
