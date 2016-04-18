hipchat-api
============
Java implementation for the HipChat V2 API. The implementation is base on - [this doc](https://www.hipchat.com/docs/apiv2).

### Build-Status:
master: [![Build Status](https://snap-ci.com/viascom/hipchat-api/branch/master/build_image)](https://snap-ci.com/viascom/hipchat-api/branch/master)<br/>
develop: [![Build Status](https://snap-ci.com/viascom/hipchat-api/branch/develop/build_image)](https://snap-ci.com/viascom/hipchat-api/branch/develop)

###  Requirements:
Java 8 (need for lambda)

### Quick Start:
To add this implementation into your project:

#### Dependency

##### maven
```xml
<dependency>
    <groupId>ch.viascom</groupId>
    <artifactId>hipchat-api</artifactId>
    <version>2.0.0-ALPHA</version>
</dependency>
```

##### gradle
```
compile 'ch.viascom:hipchat-api:2.0.0-ALPHA'
```

#### Send a notification
```java
HipChat hipChat = new HipChat("<ACCESS_CODE>");
hipChat.roomsAPI().sendRoomNotification(new Notification("Hello World", MessageColor.RED, true));
```
---

### HipChat-API

#### Validation
- [ ] Input validation

#### Wiki, Documentation & JavaDoc
- [ ] Quick-Start guide
- [ ] JavaDoc *Ongoing*
- [ ] Code coverage *Ongoing*
- [ ] JUnit *Ongoing*

### Inbounds

#### Webhook-Inbound
- [ ] Inbound models
- [ ] JWT

#### Glance-Inbound
- [ ] Inbound models
- [ ] Glance conditions
- [ ] JWT

### API-Methods:

##### Rooms API (15/41)
- [x] Get all rooms
- [x] Create room
- [x] Get room
- [x] Update room
- [x] Delete room
- [ ] Get room avatar
- [ ] Update room avatar
- [ ] Delete room avatar
- [ ] Get Room action
- [ ] Create room action
- [ ] Delete room action
- [ ] Get room dialog
- [ ] Create room dialog
- [ ] Delete room dialog
- [ ] Get room external page
- [ ] Create room external page
- [ ] Delete room external page
- [ ] Get room glance
- [ ] Create room glance
- [ ] Delete room glance
- [ ] Get room web panel
- [ ] Create room web panel
- [ ] Delete room web panel
- [x] Get room webhook
- [x] Create room webhook
- [x] Delete room webhook
- [ ] Get room message
- [ ] View room history
- [ ] View recent room history
- [ ] Invite user
- [x] Get all members
- [ ] Add member
- [ ] Remove member
- [x] Send message
- [x] Send room notification
- [x] Get all participants
- [x] Replay to message
- [ ] Share file with room
- [ ] Share link with room
- [ ] Get room statistics
- [x] Set topic
- [x] Get all webhooks
- [ ] *Create webhook -> Deprecated*
- [ ] *Get webhook -> Deprecated*
- [ ] *Delete webhook -> Deprecated*

##### Users API (0/15)
- [ ] Get all users
- [ ] Create user
- [ ] View user
- [ ] Update user
- [ ] Delete user
- [ ] Get privatechat message
- [ ] View privatechat history
- [ ] View recent privatechat history
- [ ] Private message user
- [ ] Get Photo
- [ ] Update photo
- [ ] Delete photo
- [ ] Get auto join rooms
- [ ] Share file with user
- [ ] Share link with user

##### Prefs Publics API (0/1)
- [ ] Get auto join rooms

##### OAuth Sessions API (0/3)
- [ ] Get session
- [ ] Delete session
- [ ] Generate token

##### Invites API (0/1)
- [ ] Invite user to group

##### Groups API (5/5)
- [x] View group
- [x] Get group avatar *API not ready*
- [x] Update group avatar *API not ready*
- [x] Delete group avatar *API not ready*
- [x] Group statistics

##### Emoticons API (2/2)
- [x] Get emoticon
- [x] Get all emoticons

##### Capabilities API (0/2)
- [ ] Get capabilities
- [ ] Get addon capabilities schema

##### Imports API (0/4)
- [ ] Import privatechat file
- [ ] Import privatechat history
- [ ] Import room file
- [ ] Import room history

##### Integrations API (0/8)
- [ ] Get integration installable data
- [ ] Invoke integration link
- [ ] Delete integration link
- [ ] Create integration link
- [ ] Addon ui update *BETA*
- [ ] Room addon ui update *BETA*
- [ ] User in room addon ui update *BETA*
- [ ] User addon ui update *BETA*

##### Extensions API (0/17)
- [ ] Get global action
- [ ] Create global action
- [ ] Delete global action
- [ ] Get global dialog
- [ ] Create global dialog
- [ ] Delete global dialog
- [ ] Get global external page
- [ ] Create global external page
- [ ] Delete global external page
- [ ] Get global glance
- [ ] Create global glance
- [ ] Delete global glance
- [ ] Get global web panel
- [ ] Create global web panel
- [ ] Delete global web panel
- [ ] Get global webhook
- [ ] Create global webhook
- [ ] Delete global webhook