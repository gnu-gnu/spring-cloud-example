# spring-cloud-example
Example for Spring cloud (netflix OSS, spring cloud)

이 프로젝트는 아래와 같은 요소를 포함하고 있습니다
  - eureka-server (디스커버리 서비스)
    - 3개의 peer-to-peer 디스커버리 서버
    - 각 서버는 -Dspring.profiles.active=**peer1** or **peer2** or **peer3** 옵션을 통해 구동하여야 합니다.
    - 사용하는 포트는 8800-8802 입니다. 각 서버는 상태를 확할 수 있는 대시보드를 포함합니다.
- eureka-client (간단한 백엔드)
  - 3개의 eureka-client 서비스
  - 각 서버는 -Dspring.profiles.active=**peer1** or **peer2** or **peer3** 옵션을 통해 구동하여야 합니다.
  - 사용하는 포트는 8811-8813 입니다.
- zuul-gateway (API Gateway)
  - 포트는 8888 입니다.
  - http://localhost:8888/api/client/ping 로 요청을 전송하면 로드밸런싱이 적용된 eureka-client 백엔드 호출 응답을 보여줍니다.
- spring-config-server (파일 기반 원격 컨피그 서버)
  - **/src/main/resources/config** 디렉토리 안에 위의 모든 서비스에 대한 config 파일이 위치합니다.
  - 파일 기반 구동을 위해 **-Dspring.profiles.active=native** VM args 로 실행하여야 합니다.
  - 포트는 9000을 사용합니다.
