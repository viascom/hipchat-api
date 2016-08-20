hipchat-api
============
Java implementation for the HipChat V2 API. The implementation is base on - [this doc](https://www.hipchat.com/docs/apiv2).

### Version:
[![Release-Version](https://img.shields.io/badge/release-v2.0.2--BETA-orange.svg)](http://mvnrepository.com/artifact/ch.viascom/hipchat-api/2.0.2-BETA)<br/>
[![Develop-Version](https://img.shields.io/badge/develop-v2.0.2--SNAPSHOT-orange.svg)](https://github.com/viascom/hipchat-api)

### Service Implementation Status:
[![RoomsAPI](https://img.shields.io/badge/Rooms%20API-22%20of%2045%20services-yellowgreen.svg)](https://github.com/viascom/hipchat-api#rooms-api-2245)<br/>
[![UsersAPI](https://img.shields.io/badge/Users%20API-13%20of%2015%20services-yellowgreen.svg)](https://github.com/viascom/hipchat-api#users-api-1315)<br/>
[![PrefsPublicsAPI](https://img.shields.io/badge/Prefs%20Publics%20API-1%20of%201%20services-green.svg)](https://github.com/viascom/hipchat-api#prefs-publics-api-11)<br/>
[![OAuthSessonsAPI](https://img.shields.io/badge/OAuth%20Sessions%20API-0%20of%203%20services-red.svg)](https://github.com/viascom/hipchat-api#oauth-sessions-api-03)<br/>
[![InvitesAPI](https://img.shields.io/badge/Invites%20API-1%20of%201%20services-green.svg)](https://github.com/viascom/hipchat-api#invites-api-11)<br/>
[![GroupsAPI](https://img.shields.io/badge/Groups%20API-5%20of%205%20services-green.svg)](https://github.com/viascom/hipchat-api#groups-api-55)<br/>
[![EmoticonsAPI](https://img.shields.io/badge/Emoticons%20API-2%20of%202%20services-green.svg)](https://github.com/viascom/hipchat-api#emoticons-api-22)<br/>
[![CapabilitiesAPI](https://img.shields.io/badge/Capabilities%20API-1%20of%202%20services-green.svg)](https://github.com/viascom/hipchat-api#capabilities-api-12)<br/>
[![ImportsAPI](https://img.shields.io/badge/Imports%20API-0%20of%204%20services-red.svg)](https://github.com/viascom/hipchat-api#imports-api-04)<br/>
[![IntegrationsAPI](https://img.shields.io/badge/Integrations%20API-0%20of%208%20services-red.svg)](https://github.com/viascom/hipchat-api#integrations-api-08)<br/>
[![ExtensionsAPI](https://img.shields.io/badge/Extensions%20API-0%20of%2018%20services-red.svg)](https://github.com/viascom/hipchat-api#extensions-api-018)


### Build-Status:
master: [![Build Status](https://snap-ci.com/Viascom/hipchat-api/branch/master/build_image)](https://snap-ci.com/Viascom/hipchat-api/branch/master)<br/>
develop: [![Build Status](https://snap-ci.com/Viascom/hipchat-api/branch/develop/build_image)](https://snap-ci.com/Viascom/hipchat-api/branch/develop)

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
    <version>2.0.2-BETA</version>
</dependency>
```

##### gradle
```
compile 'ch.viascom:hipchat-api:2.0.2-BETA'
```

#### Send a notification
```java
HipChat hipChat = new HipChat("<ACCESS_CODE>");
hipChat.roomsAPI().sendRoomNotification(new SendNotification("Test-Room", "Hello World", MessageColor.RED, true));
```
---

### HipChat-API

#### Validation
- [ ] Input validation

#### Exception handling
- [x] Access-Exception handling

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

##### Rooms API (22/45)
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
- [x] Get room message
- [x] View room history
- [x] View recent room history
- [x] Invite user
- [x] Get all members
- [x] Add member
- [x] Remove member
- [x] Send message
- [x] Send room notification
- [x] Get all participants
- [x] Replay to message
- [ ] Share file with room
- [ ] Share link with room
- [x] Get room statistics
- [x] Set topic
- [x] Get all webhooks
- [ ] *Create webhook -> Deprecated*
- [ ] *Get webhook -> Deprecated*
- [ ] *Delete webhook -> Deprecated*

##### Users API (13/15)
- [x] Get all users
- [x] Create user
- [x] View user
- [x] Update user
- [x] Delete user
- [x] Get privatechat message
- [x] View privatechat history
- [x] View recent privatechat history
- [x] Private message user
- [x] Get Photo
- [x] Update photo
- [x] Delete photo
- [x] Get auto join rooms
- [ ] Share file with user
- [ ] Share link with user

##### Prefs Publics API (1/1)
- [x] Get auto join rooms

##### OAuth Sessions API (0/3)
- [ ] Get session
- [ ] Delete session
- [ ] Generate token

##### Invites API (1/1)
- [x] Invite user to group

##### Groups API (5/5)
- [x] View group
- [x] Get group avatar *API not ready*
- [x] Update group avatar *API not ready*
- [x] Delete group avatar *API not ready*
- [x] Group statistics

##### Emoticons API (2/2)
- [x] Get emoticon
- [x] Get all emoticons

##### Capabilities API (1/2)
- [x] Get capabilities
- [ ] Get addon capabilities schema *API not ready*

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

##### Extensions API (0/18)
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
