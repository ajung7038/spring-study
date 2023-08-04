package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRopository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 결과가 없으면 null
        // null이 반환될 가능성이 있으면 Optional로 감싼다
        // 클라이언트에서 처리 가능
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 하나라도 찾으면 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    
    @Override
    public List<Member> findAll() {
        // 여기서 values는 Map<Long, Member>에서의 Member을 의미
        return new ArrayList<>(store.values());
    }
}
