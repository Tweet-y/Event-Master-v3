package com.example.eventmaster.data.repository;

import com.example.eventmaster.data.local.database.EventMasterDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class EventRepository_Factory implements Factory<EventRepository> {
  private final Provider<EventMasterDatabase> dbProvider;

  public EventRepository_Factory(Provider<EventMasterDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public EventRepository get() {
    return newInstance(dbProvider.get());
  }

  public static EventRepository_Factory create(
      javax.inject.Provider<EventMasterDatabase> dbProvider) {
    return new EventRepository_Factory(Providers.asDaggerProvider(dbProvider));
  }

  public static EventRepository_Factory create(Provider<EventMasterDatabase> dbProvider) {
    return new EventRepository_Factory(dbProvider);
  }

  public static EventRepository newInstance(EventMasterDatabase db) {
    return new EventRepository(db);
  }
}
