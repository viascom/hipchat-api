hipchat-api
============
Java implementation for the HipChat V2 API. The implementation is base on - [this doc](https://www.hipchat.com/docs/apiv2).

### Version:
[![Release-Version](https://img.shields.io/badge/hipchat--api-v2.0.0--ALPHA-red.svg)](http://mvnrepository.com/artifact/ch.viascom/hipchat-api/2.0.0-ALPHA)

### Service Implementation Status
[![RoomsAPI](https://img.shields.io/badge/Rooms%20API-15%20of%2041%20services-yellow.svg)](https://github.com/viascom/hipchat-api#rooms-api-1541)<br/>
[![UsersAPI](https://img.shields.io/badge/Users%20API-0%20of%2015%20services-red.svg)](https://github.com/viascom/hipchat-api#users-api-015)<br/>
[![PrefsPublicsAPI](https://img.shields.io/badge/Prefs%20Publics%20API-0%20of%201%20services-red.svg)](https://github.com/viascom/hipchat-api#prefs-publics-api-01)<br/>
[![OAuthSessonsAPI](https://img.shields.io/badge/OAuth%20Sessions%20API-0%20of%203%20services-red.svg)](https://github.com/viascom/hipchat-api#oauth-sessions-api-03)<br/>
[![InvitesAPI](https://img.shields.io/badge/Invites%20API-0%20of%201%20services-red.svg)](https://github.com/viascom/hipchat-api#invites-api-01)<br/>
[![GroupsAPI](https://img.shields.io/badge/Groups%20API-5%20of%205%20services-green.svg)](https://github.com/viascom/hipchat-api#groups-api-55)<br/>
[![EmoticonsAPI](https://img.shields.io/badge/Emoticons%20API-2%20of%202%20services-green.svg)](https://github.com/viascom/hipchat-api#emoticons-api-22)<br/>
[![CapabilitiesAPI](https://img.shields.io/badge/Capabilities%20API-0%20of%202%20services-red.svg)](https://github.com/viascom/hipchat-api#capabilities-api-02)<br/>
[![ImportsAPI](https://img.shields.io/badge/Imports%20API-0%20of%204%20services-red.svg)](https://github.com/viascom/hipchat-api#imports-api-04)<br/>
[![IntegrationsAPI](https://img.shields.io/badge/Integrations%20API-0%20of%208%20services-red.svg)](https://github.com/viascom/hipchat-api#integrations-api-08)<br/>
[![ExtensionsAPI](https://img.shields.io/badge/Extensions%20API-0%20of%2017%20services-red.svg)](https://github.com/viascom/hipchat-api#extensions-api-017)


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

#### Exception handling
- [ ] Scope-Exception handling
- [ ] Access-Exception handling

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