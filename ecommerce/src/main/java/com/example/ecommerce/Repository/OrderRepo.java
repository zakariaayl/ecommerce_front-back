package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class OrderRepo implements OrderRepoInt{
private final SessionFactory sessionfactory;

    public OrderRepo(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        try(Session session=sessionfactory.openSession()){
            session.beginTransaction();
            session.save(entity);
            session.flush();
            session.getTransaction().commit();
            return entity;
        }

    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(Integer integer) {
        return null;
    }

    @Override
    public Order getById(Integer integer) {
        return null;
    }

    @Override
    public Order getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Order> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        try(Session session=sessionfactory.openSession()){
            session.beginTransaction();
            Order orders=session.createQuery("select user from Order user where user.id= :var",Order.class).setParameter("var",integer).uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(orders);
        }
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        try(Session session=sessionfactory.openSession()){
            session.beginTransaction();
            List<Order> orders=session.createQuery("select user from Order user",Order.class).list();
            session.getTransaction().commit();
            return orders;
        }
    }

    @Override
    public List<Order> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }
}
