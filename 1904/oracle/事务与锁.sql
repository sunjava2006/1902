select * from t_t;
delete from t_t where student_id=1;
savepoint a;
delete from t_t where student_id=2;
savepoint b;
delete from t_t;

rollback to b;
rollback to a;

rollback;

commit;
